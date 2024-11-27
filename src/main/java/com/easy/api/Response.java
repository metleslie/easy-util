package com.easy.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 响应参数
 *
 * @author: daimao
 * @date: 2024-11-21 00:20
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@SuppressWarnings("ALL")
public class Response<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;
    /**
     * 追踪id
     */
    private String traceId;


    /**
     * 创建一个表示响应对象
     *
     * @param responseCode 响应代码
     * @return 返回一个响应
     */
    public static <T> Response<T> create(ResponseCode responseCode) {
        return new Response<>(responseCode.getCode(), responseCode.getMessage(), null, null);
    }

    /**
     * 创建一个表示响应对象
     *
     * @param responseCode 响应代码
     * @return 返回一个响应
     */
    public static <T> Response<T> create(ResponseCode responseCode, T data) {
        return new Response<>(responseCode.getCode(), responseCode.getMessage(), data, null);
    }

    /**
     * 创建一个表示响应对象
     *
     * @param responseCode 响应代码
     * @return 返回一个响应
     */
    public static <T> Response<T> create(ResponseCode responseCode, T data, String traceId) {
        return new Response<>(responseCode.getCode(), responseCode.getMessage(), data, traceId);
    }

}

