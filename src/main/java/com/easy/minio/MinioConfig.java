package com.easy.minio;


import lombok.Data;

/**
 * minio配置
 *
 * @author: daimao
 * @date: 2024-11-27 10:23
 */
@Data
public class MinioConfig {
    /**
     * 终端
     */
    private final String endpoint;
    /**
     * 访问密钥
     */
    private final String accessKey;
    /**
     * 密钥
     */
    private final String secretKey;

    public MinioConfig(String endpoint, String accessKey, String secretKey) {
        this.endpoint = endpoint;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "MinioConfig{" +
                "endpoint='" + endpoint + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MinioConfig that = (MinioConfig) o;
        return endpoint.equals(that.endpoint) && accessKey.equals(that.accessKey) && secretKey.equals(that.secretKey);
    }

    @Override
    public int hashCode() {
        int result = endpoint != null ? endpoint.hashCode() : 0;
        result = 31 * result + (accessKey != null ? accessKey.hashCode() : 0);
        result = 31 * result + (secretKey != null ? secretKey.hashCode() : 0);
        return result;
    }
}
