package com.yun.reader.common.helper;

import com.yun.reader.common.storage.Sps;

import java.lang.reflect.Type;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class SpHelper {
    public static Sps sps = new Sps();

    public static void putString(String key, String value) {
        sps.put(key, value);
    }

    public static String getString(String key) {
        return sps.getString(key);
    }

    public static void putBean(String key, Object object) {
        sps.putBean(key, object);
    }

    public static Object getBean(String key, Type type) {
        return sps.getBean(key, type);
    }
}
