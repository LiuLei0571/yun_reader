package com.yun.reader.common.helper;

import com.yun.reader.common.storage.Sps;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class SpsHelper {
    public static Sps sps = new Sps();

    public static void putString(String key, String value) {
        sps.put(key, value);
    }

    public static String getString(String key) {
        return sps.getString(key);
    }
}
