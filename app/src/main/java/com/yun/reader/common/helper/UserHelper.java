package com.yun.reader.common.helper;

import com.yun.reader.compent.dagger.ReaderControlHelper;
import com.yun.reader.product.login.module.bean.LoginAuto;
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
    public static LoginAuto getUserInfo() {
        if (userManager != null) {
            LoginAuto localLoginAuto = userManager.getLocalLoginAuto();
            return localLoginAuto;
        }
        return null;
    }
}
