package com.yun.reader.compent.init;

import android.content.Context;
import android.util.Log;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public enum AppInit {
    framework("框架", FrameWorkInit.class),
    file("文件系统", FileInit.class);
    private String initModuleName;
    private Class<? extends AppInitImpl> clazz;
    private boolean isInit = false;

    AppInit(String initModuleName, Class<? extends AppInitImpl> frameWorkInitClass) {
        this.initModuleName = initModuleName;
        this.clazz = frameWorkInitClass;
    }

    AppInit(Class<? extends AppInitImpl> clazz) {
        this.clazz = clazz;
    }

    public String getInitModuleName() {
        return initModuleName;
    }

    public static AppInit[] allAppInit = new AppInit[]{
            framework, file
    };

    public static void initFrame(Context context, AppInit... appInits) {
        if (appInits != null && appInits.length > 0) {
            long startTime = System.currentTimeMillis();
            for (AppInit appInit : appInits) {
                if (context != null && appInit.doInit(context)) {

                    long endTime = System.currentTimeMillis();
                    Log.d(appInit.getInitModuleName(), "initTime: " + (endTime - startTime));
                    startTime = endTime;
                }
            }
        }

    }

    private boolean doInit(Context context) {
        if (!isInit) {
            isInit = true;
            try {
                AppInitImpl iAppInit = clazz.newInstance();
                iAppInit.init(context);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }
}
