package com.yun.reader;

import android.app.Application;
import android.content.Context;

import com.yun.reader.compent.init.AppInit;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public class App extends Application {
    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        AppInit.initFrame(appContext, AppInit.allAppInit);
    }

    public static Context getAppContext() {
        return appContext;
    }
}
