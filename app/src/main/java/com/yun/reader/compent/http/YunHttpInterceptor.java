package com.yun.reader.compent.http;

import com.yun.reader.common.util.DeviceUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/28 .
 * 邮箱:liulei@getui.com.
 */


public class YunHttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Map<String, String> params = new HashMap<>();
        params.put("platform", DeviceUtil.getPlatForm());
        params.put("build", DeviceUtil.getPackageId());
        params.put("channel", "170080");
        params.put("deviceId", DeviceUtil.getDeviceId());
        params.put("mac",DeviceUtil.getMAC());
        params.put("imei", DeviceUtil.getIMEI());
        params.put("deviceSDK", DeviceUtil.getDeviceSdk());
        params.put("aid",DeviceUtil.getAid());
        HttpUrl.Builder httpUrlBuilder = request.url().newBuilder();
        for (String key : params.keySet()) {
            String value = params.get(key);
            httpUrlBuilder.addQueryParameter(key, value);
        }
        return chain.proceed(request.newBuilder().url(httpUrlBuilder.build()).build());
    }

}
