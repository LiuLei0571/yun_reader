package com.yun.reader.compent.conver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class SpecialGsonConverterFactory extends Converter.Factory {
    private final Gson gson;

    public static SpecialGsonConverterFactory create() {
        return create(new Gson());
    }

    public static SpecialGsonConverterFactory create(Gson gson) {
        return new SpecialGsonConverterFactory(gson);
    }

    private SpecialGsonConverterFactory(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.gson = gson;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }
}
