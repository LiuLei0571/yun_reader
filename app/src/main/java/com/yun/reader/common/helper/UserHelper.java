package com.yun.reader.common.helper;

import com.yun.reader.compent.dagger.ReaderControlHelper;
import com.yun.reader.product.user.UserInfo;
import com.yun.reader.product.user.module.UserManager;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/30 .
 * 邮箱 liulei@getui.com.
 */


public class UserHelper {
    private static UserManager userManager;

    static {
            userManager = ReaderControlHelper.getInstance().userManager;
    }
    public static UserInfo getUserInfo() {
        if (userManager != null) {
            UserInfo userInfo = userManager.getLocalUserInfo();
            return userInfo;
        }
        return null;
    }
}
