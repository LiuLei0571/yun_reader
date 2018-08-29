package com.yun.reader.compent.conver;

import android.util.Log;

import com.yun.reader.common.exception.RestError;
import com.yun.reader.common.file.FileStrings;
import com.yun.reader.common.helper.FileHelper;
import com.yun.reader.common.helper.JsonHelper;
import com.yun.reader.common.http.response.ResultResponse;
import com.yun.reader.compent.constant.RequestParams;
import com.yun.reader.product.reader.manager.module.DownloadFileResponse;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.UUID;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, ResultResponse> {
    private String TAG = "response";
    private Type type;

    public GsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public ResultResponse convert(ResponseBody responseBody) throws IOException {
        ResultResponse response = null;
        if (responseBody.contentType().toString().startsWith(RequestParams.APPLICATION_OCTET_STREAM) || responseBody.contentType().toString().startsWith("cover/png") || responseBody.contentType().toString().startsWith("cover/jpg") || responseBody.contentType().toString().startsWith("image/gif") || responseBody.contentType().toString().startsWith("image/jpeg") || responseBody.contentType().toString().startsWith("application/x-7z-compressed")) {
            String uuid = UUID.randomUUID().toString();
            response = new ResultResponse<DownloadFileResponse>();
            try {
                boolean isDownSuccess = FileHelper.getInstance().downFile(responseBody, FileStrings.DOWNLOAD, uuid);
                if (isDownSuccess) {
                    response = new ResultResponse<DownloadFileResponse>();
                    DownloadFileResponse downloadFileResponse = new DownloadFileResponse();
                    downloadFileResponse.setFile(new File(FileStrings.DOWNLOAD, uuid));
                    response.setCode(0);
                    response.setData(downloadFileResponse);
                } else {
                    response.setCode(1);
                    response.setMessage("下载失败");
                }
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            responseBody.close();
        } else if (responseBody.contentType().toString().startsWith("application/json")) {
            try {
                String responseBodyString = responseBody.string();
                Log.d(TAG, responseBodyString);
                ResultResponse resultResponse = JsonHelper.fromJson(responseBodyString, ResultResponse.class);
                if (resultResponse == null) {
                    throw RestError.JSONCoverError(responseBody.string());
                } else if (resultResponse.getCode() == 0) {
                    response = JsonHelper.fromJson(responseBodyString, type);
                    responseBody.close();
                }
            } catch (Throwable th) {
                throw RestError.ContentTypeError();
            }
        }

        return response;
    }
}
