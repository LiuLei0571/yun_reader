package com.yun.reader.compent.dagger;

import android.content.Context;

import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.yun.reader.compent.cookie.PersistentCookieJar;
import com.yun.reader.compent.http.RetrofitControl;
import com.yun.reader.compent.image.DisplayOption;
import com.yun.reader.compent.image.ImageShowImpl;
import com.yun.reader.compent.image.glide.GlideImageLoader;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CookieJar;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */

@Module
public class ReaderModule {
    private final Context application;

    public ReaderModule(Context application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplication() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public ImageShowImpl provideImageLoader() {
        GlideImageLoader glideImageLoader = new GlideImageLoader(application.getApplicationContext());
        DisplayOption displayOption = DisplayOption.builder();
        glideImageLoader.setGlideImage(displayOption);
        return glideImageLoader;
    }

    @Provides
    @Singleton
    public RetrofitControl provideRetrofit() {
        RetrofitControl retrofitControl = RetrofitControl.getInstance();
        return retrofitControl;
    }

    @Provides
    @Singleton
    public CookieJar provideCookJar() {
        PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(application));
        return persistentCookieJar;
    }

    @Provides
    @Singleton
    public okhttp3.OkHttpClient provideOkHttp3(PersistentCookieJar cookieJar) {
        okhttp3.OkHttpClient.Builder okHttpClientBuilder = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(15000, TimeUnit.MILLISECONDS)
                .readTimeout(60000, TimeUnit.MILLISECONDS)
                .writeTimeout(60000, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar);
        return okHttpClientBuilder.build();
    }
}
