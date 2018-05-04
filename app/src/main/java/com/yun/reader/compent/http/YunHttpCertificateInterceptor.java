package com.yun.reader.compent.http;

import com.yun.reader.common.helper.TokenHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class YunHttpCertificateInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder builder = request.newBuilder().method(request.method(), request.body());
        builder.header("Authorization", TokenHelper.getUserToken());
        return chain.proceed(builder.build());
    }
}
