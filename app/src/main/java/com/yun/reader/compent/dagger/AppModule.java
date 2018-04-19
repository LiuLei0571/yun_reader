package com.yun.reader.compent.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */

@Module
public class AppModule {
    private final Context application;

    public AppModule(Context application) {
        this.application = application;
    }
    @Provides
    @Singleton
    public  Context provideApplication(){
        return application.getApplicationContext();
    }
}
