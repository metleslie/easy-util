package com.easy.minio;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.apache.tika.Tika;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-11-25 15:56
 */
@SuppressWarnings("ALL")
public class MinIOUtil {
    /**
     * 保存实例
     */
    private static final Map<MinioConfig, MinIOUtil> INSTANCE_MAP = new ConcurrentHashMap<>();

    /**
     * minio 配置
     */
    private final MinioClient minioClient;

    /**
     * 私有构造方法
     */
    private MinIOUtil(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    /**
     * 获得实例
     *
     * @param minioConfig minio 配置
     * @return minio 实例
     */
    public static MinIOUtil getInstance(MinioConfig minioConfig) {
        //computeIfAbsent() 是原子操作可以保证线程安全
        return INSTANCE_MAP.computeIfAbsent(minioConfig, config -> {
            try {
                MinioClient minioClient = MinioClient.builder()
                        .endpoint(config.getEndpoint())
                        .credentials(config.getAccessKey(), config.getSecretKey())
                        .build();
                return new MinIOUtil(minioClient);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create MinioClient", e);
            }
        });
    }

    public void upload(InputStream inputStream, String bucketName, String objectName) throws Exception {
        // 将输入流读取到字节数组中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        byte[] bytes = baos.toByteArray();
        // 从字节数组创建新的输入流
        InputStream newInputStream = new ByteArrayInputStream(bytes);
        // 自动检测对象大小
        long objectSize = bytes.length;
        // 自动检测内容类型
        Tika tika = new Tika();
        String contentType = tika.detect(newInputStream);
        // 设置 partSize 为 10 MB
        int partSize = 10 * 1024 * 1024;
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(newInputStream, objectSize, partSize)
                .contentType(contentType)
                .build();
        minioClient.putObject(putObjectArgs);
        minioClient.close();
    }
}
