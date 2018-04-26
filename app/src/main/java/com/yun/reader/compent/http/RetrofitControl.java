package com.yun.reader.compent.http;


/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/25 .
 * 邮箱:liulei@getui.com.
 */


public class RetrofitControl {
    private static RetrofitControl retrofitControl;

    public static RetrofitControl getInstance() {
        if (retrofitControl == null) {
            synchronized (RetrofitControl.class) {
                if (retrofitControl == null) {
                    retrofitControl = new RetrofitControl();
                }
            }
        }
        return retrofitControl;
    }
}
