package com.yun.reader.compent.conver;

import android.util.Log;

import com.yun.reader.common.exception.RestError;
import com.yun.reader.common.helper.JsonHelper;
import com.yun.reader.common.http.response.ResultResponse;
import com.yun.reader.compent.constant.RequestParams;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private String TAG = "response";
    private Type type;

    public GsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        T downloadFileResponse = null;
        if (responseBody.contentType().toString().startsWith(RequestParams.APPLICATION_OCTET_STREAM) || responseBody.contentType().toString().startsWith("cover/jpeg") || responseBody.contentType().toString().startsWith("image/gif") || responseBody.contentType().toString().startsWith("image/jpeg") || responseBody.contentType().toString().startsWith("application/x-7z-compressed")) {

        } else if (responseBody.contentType().toString().startsWith("application/json")) {
            try {
                String responseBodyString = responseBody.string();
                Log.d(TAG, responseBodyString);
                ResultResponse resultResponse = JsonHelper.fromJson(responseBodyString, ResultResponse.class);
                if (resultResponse == null) {
                    throw RestError.JSONCoverError(responseBody.string());
                } else if (resultResponse.getCode() == 0) {
                    downloadFileResponse = JsonHelper.fromJson(responseBodyString, type);
                    responseBody.close();
                }
            } catch (Throwable th) {
                throw RestError.ContentTypeError();
            }
        }

        return downloadFileResponse;
    }
}
