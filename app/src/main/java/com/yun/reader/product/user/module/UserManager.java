package com.yun.reader.product.user.module;

import com.yun.reader.common.cache.CacheHelper;
import com.yun.reader.common.config.CacheKeys;
import com.yun.reader.common.config.SpKeys;
import com.yun.reader.common.helper.SpHelper;
import com.yun.reader.compent.base.BaseManager;
import com.yun.reader.product.user.UserInfo;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/28 .
 * 邮箱:liulei@getui.com.
 */


public class UserManager extends BaseManager {

    public UserInfo getLocalUserInfo() {
        UserInfo userInfo = CacheHelper.getCache(CacheKeys.YUN_USER_INFO);
        if (userInfo == null) {
            userInfo = SpHelper.getBean(SpKeys.USER_INFO, UserInfo.class);
            CacheHelper.putCache(CacheKeys.YUN_USER_INFO, userInfo);
        }
        return userInfo;
    }

    public void saveLocalUserInfo(UserInfo userInfo) {
        SpHelper.putBean(SpKeys.USER_INFO, userInfo);
        CacheHelper.putCache(CacheKeys.YUN_USER_INFO, userInfo);
    }
}
