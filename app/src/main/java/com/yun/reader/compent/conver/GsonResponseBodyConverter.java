package com.yun.reader.compent.conver;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.yun.reader.common.exception.RestError;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        T downloadFileResponse = null;
        try {
            ResultResponse resultResponse = gson.fromJson(responseBody.toString(), ResultResponse.class);
            if (resultResponse == null) {
                throw RestError.JSONCoverError(responseBody.toString());
            } else if (resultResponse.getCode() == 0) {
                downloadFileResponse = this.adapter.fromJson(responseBody.toString());
            }
        } catch (Throwable th) {
            throw RestError.ContentTypeError();
        } finally {
            responseBody.close();
        }
        return downloadFileResponse;
    }
}
