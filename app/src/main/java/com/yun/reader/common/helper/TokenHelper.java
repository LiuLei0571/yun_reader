package com.yun.reader.common.helper;

import com.yun.reader.common.storage.Sps;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class TokenHelper {
    public static String getUserToken() {
        Sps sps = new Sps();
        return sps.getString("login_token");
    }
}
