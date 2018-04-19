package com.yun.reader.common.util;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public class StringUtils {
    public static boolean isStringEmpty(String string) {
        return string == null || string.length() == 0 || "".equals(string) || "null".equals(string);
    }

    public static boolean isStringNotEmpty(String string) {
        return !isStringEmpty(string);
    }
}
