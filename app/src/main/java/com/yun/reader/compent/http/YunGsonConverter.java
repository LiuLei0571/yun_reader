package com.yun.reader.compent.http;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: Converter */
/* renamed from: retrofit2.e */
public interface YunGsonConverter<F, T> {

    /* compiled from: Converter */
    /* renamed from: retrofit2.e$a */
    public static abstract class DefaultConver {
        public YunGsonConverter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, YunRequest yunRequest) {
            return null;
        }

        public YunGsonConverter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, YunRequest yunRequest) {
            return null;
        }

        public YunGsonConverter<?, String> stringConverter(Type type, Annotation[] annotationArr, YunRequest yunRequest) {
            return null;
        }
    }

    T convert(F f) throws IOException;
}
