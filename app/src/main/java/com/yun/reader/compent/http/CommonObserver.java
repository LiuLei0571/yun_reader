package com.yun.reader.compent.http;

import com.yun.reader.common.http.response.ResultResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/28 .
 * 邮箱:liulei@getui.com.
 */


public abstract class CommonObserver<T> implements Observer<ResultResponse<T>>, ISubscribe<T> {
    private String TAG = "CommonObserver";

    @Override
    public void doSubscribe(Disposable d) {
    }

    @Override
    public void doFinish() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        doSubscribe(d);
    }

    @Override
    public void onNext(ResultResponse<T> tResultResponse) {
        doSuccess(tResultResponse);
    }

    @Override
    public void onError(Throwable e) {
     }
    @Override
    public void onComplete() {
    }
}
