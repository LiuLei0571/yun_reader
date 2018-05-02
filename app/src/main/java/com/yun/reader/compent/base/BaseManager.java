package com.yun.reader.compent.base;

import com.yun.reader.YunApplication;
import com.yun.reader.compent.dagger.ReaderControlHelper;
import com.yun.reader.compent.http.CommonConsumer;
import com.yun.reader.compent.http.RetrofitApis;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/27 .
 * 邮箱:liulei@getui.com.
 */


public class BaseManager {
    protected static RetrofitApis retrofitApis;

    static {
        retrofitApis = ReaderControlHelper.getInstance().retrofitManager.provideRetrofit();
    }

    protected <T> void handlerObserver(Observable<? extends T>  observable, Observer commonObserver) {
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new CommonConsumer<Disposable>(YunApplication.appContext))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commonObserver);
    }
}
