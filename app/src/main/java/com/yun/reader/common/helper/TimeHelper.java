package com.yun.reader.common.helper;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/6/4 .
 * 邮箱 liulei@getui.com.
 */


public class TimeHelper {
    public static long getSecondByMillisecond(long millisecond) {
        if (millisecond > 0) {
            return millisecond / 1000;

        } else {
            return 0;
        }
    }
}
