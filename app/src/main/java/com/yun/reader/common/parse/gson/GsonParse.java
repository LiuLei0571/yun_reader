package com.yun.reader.common.parse.gson;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yun.reader.common.parse.ParseImpl;

import java.lang.reflect.Type;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class GsonParse implements ParseImpl {
    private Gson gson;

    public GsonParse() {
        gson = initGson();
    }

    @NonNull
    public static Gson initGson() {
        return new GsonBuilder()
                .serializeNulls()
                .disableHtmlEscaping()
//                .setExclusionStrategies(new SpecificClassExclusionStrategy(null, ResultResponse.class))
                .enableComplexMapKeySerialization()
                .create();
    }

    @Override
    public String toJson(Object bean) {
        if (bean != null) {
            return gson.toJson(bean);
        }
        return null;
    }

    @Override
    public <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    @Override
    public <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }
}
