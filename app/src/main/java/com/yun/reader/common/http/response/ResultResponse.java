package com.yun.reader.common.http.response;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/27 .
 * 邮箱:liulei@getui.com.
 */


public class ResultResponse<T> {
    private String message;
    private int code;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
