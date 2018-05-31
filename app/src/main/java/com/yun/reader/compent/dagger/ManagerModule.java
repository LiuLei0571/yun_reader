package com.yun.reader.compent.dagger;

import com.yun.reader.product.MainManager;
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
    @Singleton
    public MainManager provideMainManager() {
        return new MainManager();
    }

    @Provides
    @Singleton
    public UserManager provideUserManager() {
        return new UserManager();
    }
}
