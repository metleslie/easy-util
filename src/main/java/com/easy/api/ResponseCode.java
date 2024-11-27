package com.easy.api;

/**
 * 响应接口
 *
 * @param <T> 泛型参数，表示响应数据的类型
 * @author daimao
 * /**
 * 接口 IResponseCode 定义了响应码、响应数据、错误消息和追踪ID的获取方法
 * 它提供了一种标准的方式来获取API响应中的这些关键信息
 */
public interface ResponseCode {
    /**
     * 获取响应码
     * 响应码用于标识响应的状态，例如成功、各种类型的错误等
     *
     * @return 响应码字符串
     */
    long getCode();

    /**
     * 获取错误消息
     * 错误消息用于提供有关错误或状态的更详细信息，帮助开发者理解响应码的含义
     *
     * @return 错误消息字符串
     */
    String getMessage();

}
