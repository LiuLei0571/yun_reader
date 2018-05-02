package com.yun.reader.compent.http;

import android.content.Context;

import io.reactivex.functions.Consumer;

/**
 * 用途：
 * 作者：Created by liulei on 2017/11/27.
 * 邮箱：liulei2@aixuedai.com
 */


public class CommonConsumer<T> implements Consumer<T> {
    private Context context;

    public CommonConsumer(Context context) {
        this.context = context;
    }

    @Override
    public void accept(T t) throws Exception {
    }
}
