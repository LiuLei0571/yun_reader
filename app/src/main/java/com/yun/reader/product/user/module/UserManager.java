package com.yun.reader.product.user.module;

import com.yun.reader.common.cache.CacheHelper;
import com.yun.reader.common.config.CacheKeys;
import com.yun.reader.common.config.SpKeys;
import com.yun.reader.common.helper.SpHelper;
import com.yun.reader.compent.base.BaseManager;
import com.yun.reader.compent.http.CommonObserver;
import com.yun.reader.product.login.module.bean.LoginAuto;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/28 .
 * 邮箱:liulei@getui.com.
 */


public class UserManager extends BaseManager {

    public LoginAuto getLocalLoginAuto() {
        LoginAuto userInfo = CacheHelper.getCache(CacheKeys.LOGIN_AUTO);
        if (userInfo == null) {
            userInfo = SpHelper.getBean(SpKeys.LOGIN_AUTO, LoginAuto.class);
            CacheHelper.putCache(CacheKeys.LOGIN_AUTO, userInfo);
        }
        return userInfo;
    }

    public void saveLocalLoginAuto(LoginAuto userInfo) {
        SpHelper.putBean(SpKeys.LOGIN_AUTO, userInfo);
        CacheHelper.putCache(SpKeys.LOGIN_AUTO, userInfo);
    }
    public void loginAuto(CommonObserver commonObserver) {
        Map<String, Object> params = new HashMap<>();
        params.put("via", "auto");
        handlerObserver(retrofitApis.login(params), commonObserver);
    }
}
