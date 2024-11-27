package com.easy.datetime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 日期格式
 *
 * @author: daimao
 * @date: 2024-11-20 20:55
 */

@Getter
@AllArgsConstructor
public enum DatePattern {

    YYYY_MM_DD_HH_MM_SS_SSS("yyyy-MM-dd HH:mm:ss.SSS"),
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm"),
    YYYY_MM_DD("yyyy-MM-dd"),
    YYYYMMDD("yyyyMMdd"),
    YYYY_MM("yyyy-MM"),
    YYYY("yyyy");

    private final String pattern;

    public static DatePattern getInstance(String pattern) {
        return DatePattern.valueOf(pattern);
    }
}
