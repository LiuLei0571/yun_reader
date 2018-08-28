package com.yun.reader.common.helper;

import android.text.TextUtils;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class TokenHelper {
    public static String getUserToken() {
        if (TextUtils.isEmpty(SpHelper.getString("login_token"))) {
            return "";
        }
        return "Bearer " + SpHelper.getString("login_token");
    }

    public static void setUserToken(String value) {
        SpHelper.putString("login_token", value);
    }
}
