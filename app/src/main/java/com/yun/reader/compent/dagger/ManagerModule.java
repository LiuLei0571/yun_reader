package com.yun.reader.compent.dagger;

import com.yun.reader.product.login.module.LoginAutoManager;
import com.yun.reader.product.reader.manager.ReadeDetailManager;
import com.yun.reader.product.setting.module.SubscriptionManager;
import com.yun.reader.product.user.module.UserManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/23 .
 * 邮箱:liulei@getui.com.
 */

@Module
public class ManagerModule {

    @Provides
    protected UserManager provideUserManager() {
        return new UserManager();
    }

    @Provides
    @Singleton
    protected LoginAutoManager provideMainManager() {
        return new LoginAutoManager();
    }

    @Provides
    @Singleton
    protected SubscriptionManager provideSubscriptionManager() {
        return new SubscriptionManager();
    }

    @Provides
    @Singleton
    protected ReadeDetailManager provideReadeDetailManager() {
        return new ReadeDetailManager();
    }
}
