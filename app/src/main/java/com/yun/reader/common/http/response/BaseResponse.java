package com.yun.reader.common.http.response;

import java.io.Serializable;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/26 .
 * 邮箱:liulei@getui.com.
 */


public class BaseResponse<T> implements Serializable{
    private int code;
    private T data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

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
}
