package com.easy.datetime;

import com.easy.convert.Convert;

import java.time.LocalDateTime;

/**
 * 时间对象
 *
 * @author: daimao
 * @date: 2024-11-20 20:36
 */
@SuppressWarnings("ALL")
public class Datetime {
    /**
     * 时间对象
     */
    private LocalDateTime localDateTime;

    /**
     * 构造函数
     */
    public Datetime() {
        this.localDateTime = LocalDateTime.now();
    }

    /**
     * 构造函数
     *
     * @param localDateTime
     */
    public Datetime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static Datetime now() {
        return new Datetime();
    }

    /**
     * 当天开始时间
     *
     * @return
     */
    public Datetime startOfDay() {
        return new Datetime(this.localDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0));
    }

    /**
     * 当天结束时间
     *
     * @return
     */
    public Datetime endOfDay() {
        return new Datetime(this.localDateTime.withHour(23).withMinute(59).withSecond(59).withNano(999999999));
    }

    /**
     * 时间字符串
     *
     * @return
     */
    public String toString() {
        return Convert.toDatetimeStr(this.localDateTime);
    }
}
