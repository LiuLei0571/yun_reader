package com.yun.reader.common.helper;

import android.os.Handler;
import android.os.Looper;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/25 .
 * 邮箱:liulei@getui.com.
 */


public class ThreadHelper {
    private final static Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    public static boolean isHandleInMain() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void postMainHandler(final Runnable runnable) {
        MAIN_HANDLER.post(runnable);
    }

    public static void postMainHandlerDelay(final Runnable runnable, long delayMillisecond) {
        MAIN_HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable throwable) {

                }
            }
        }, delayMillisecond);
    }
}
