package com.yun.reader.common.exception;

public class RestError extends RuntimeException {
    private int code;
    private String responseData;

    public RestError(int i, String str) {
        super(str);
        this.code = i;
    }

    public RestError(int i, String str, String str2) {
        super(str);
        this.code = i;
        this.responseData = str2;
    }

    @Override
    public String toString() {
        return "RestError{code=" + this.code + ", msg='" + getMessage() + '\'' + ", responseData='" + getResponseData() + '\'' + '}';
    }

    public String getResponseData() {
        return this.responseData;
    }

    public void setResponseData(String str) {
        this.responseData = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return getMessage();
    }

    public static RestError JSONCoverError(String str) {
        return new RestError(9902, "", str);
    }

    public static RestError ContentTypeError() {
        return new RestError(9904, "");
    }

    public static RestError NetwokrError() {
        return new RestError(9905, "网络不可用，请检查您的网络设置");
    }

    public static RestError NetwokrTimeOutError() {
        return new RestError(9905, "网络不给力，请重试");
    }

    public static RestError SSLNetworkError() {
        return new RestError(9910, "请正确设置手机日期与时间");
    }

    public static RestError customError(String str) {
        return new RestError(9906, str);
    }

    public static RestError unZipChapterFile(String str) {
        return new RestError(9907, "");
    }

    public static RestError DownloadChapterFileError(String str) {
        return new RestError(9908, "");
    }
}
