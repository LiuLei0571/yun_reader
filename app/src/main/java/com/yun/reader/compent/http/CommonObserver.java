package com.yun.reader.compent.http;

import android.util.Log;

import com.yun.reader.compent.conver.ResultResponse;

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
        Log.d(TAG, "doSubscribe: ");
    }

    @Override
    public void doFinish() {
        Log.d(TAG, "doFinish: ");
    }

    @Override
    public void onSubscribe(Disposable d) {
        doSubscribe(d);
        Log.d(TAG, "onSubscribe: ");
    }

    @Override
    public void onNext(ResultResponse<T> tResultResponse) {
        Log.d(TAG, "onNext: ");
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: ");
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }
}
