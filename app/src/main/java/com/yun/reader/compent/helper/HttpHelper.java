package com.yun.reader.compent.helper;

import com.yun.reader.YunApplication;
import com.yun.reader.compent.dagger.ReaderControlHelper;
import com.yun.reader.compent.http.CommonConsumer;
import com.yun.reader.compent.http.CommonObserver;
import com.yun.reader.compent.http.RetrofitManager;

import java.util.Map;

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


public class HttpHelper {
    private static RetrofitManager retrofitManager;

    static {
        retrofitManager = ReaderControlHelper.getInstance().retrofitManager;
    }


    public static void execute(CommonObserver commonObserver, Map<String,Object> parmas) {
        retrofitManager.provideRetrofit().login(parmas)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new CommonConsumer<Disposable>(YunApplication.appContext))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commonObserver);
    }
}
