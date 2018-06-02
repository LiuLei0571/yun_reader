package com.yun.reader.compent.init;

import android.content.Context;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public enum AppInit {
    framework("框架", FrameWorkInit.class);
    private String desc;
    private Class<? extends AppInitImpl> clazz;
    private boolean isInit = false;

    AppInit(String desc, Class<? extends AppInitImpl> frameWorkInitClass) {
        this.desc = desc;
        this.clazz = frameWorkInitClass;
    }

    AppInit(Class<? extends AppInitImpl> clazz) {
        this.clazz = clazz;
    }

    public String getDesc() {
        return desc;
    }

    public static AppInit[] allAppInit = new AppInit[]{
            framework
    };

    public static void initFrame(Context context, AppInit... appInits) {
        for (AppInit appInit : appInits) {
            if (context != null) {
                appInit.doInit(context);

            }
        }
    }

    private void doInit(Context context) {
        if (!isInit) {
            isInit = true;
            try {
                AppInitImpl iAppInit = clazz.newInstance();
                iAppInit.init(context);
            } catch (Exception e) {

            }
        }
    }
}
