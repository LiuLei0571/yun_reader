package com.yun.reader.compent.http;


import retrofit2.Retrofit;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/25 .
 * 邮箱:liulei@getui.com.
 */


public class RetrofitManager {
    private Retrofit retrofit;

    public RetrofitManager(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public RetrofitApis provideRetrofit() {
       return retrofit.create(RetrofitApis.class);
    }
}
