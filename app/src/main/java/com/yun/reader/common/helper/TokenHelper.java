package com.yun.reader.common.helper;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class TokenHelper {
    public static String getUserToken() {
        return SpsHelper.getString("login_token");
    }

    public static void setUserToken(String value) {
        SpsHelper.putString("login_token", value);
    }
}
