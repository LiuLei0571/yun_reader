package com.yun.reader.common.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 软引用缓存
 */
public final class CacheHelper {
    private final static Map<String, SoftReference<Object>> cache = new HashMap<>();

    private static Map<String, SoftReference<Object>> getCache() {
        return cache;
    }

    public static <T> T getCache(String key) {
        SoftReference<T> value = (SoftReference<T>) getCache().get(key);
        if (value != null) {
            return value.get();
        }
        return null;
    }

    public static <T> void putCache(String key, T value) {
        getCache().put(key, new SoftReference<Object>(value));
    }

    public static void remove(String key) {
        getCache().remove(key);
    }

    public static boolean containsKey(String key) {
        return getCache().containsKey(key);
    }
}
