package com.easy.util;

import java.util.*;

/**
 * 集合工具类
 *
 * @author: daimao
 * @date: 2024-10-30 20:51
 */
@SuppressWarnings(value = "ALL")
public class CollUtils {

    private CollUtils(){

    }

    /**
     * 加入全部
     *
     * @param <T>        集合元素类型
     * @param collection 被加入的集合 {@link Collection}
     * @param iterable   要加入的内容{@link Iterable}
     */
    public static <T> void addAll(Collection<T> collection, Collection<T> iterable) {
        if (iterable != null) {
            collection.addAll(iterable);
        }
    }

    /**
     * 判断集合是否为空
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断集合是否非空
     *
     * @param collection 集合
     * @return 是否非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

}

