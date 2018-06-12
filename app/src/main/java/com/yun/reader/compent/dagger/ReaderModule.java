package com.yun.reader.compent.dagger;

import android.content.Context;
import android.content.res.AssetManager;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.yun.reader.common.config.ApiConfig;
import com.yun.reader.common.parse.gson.GsonParse;
import com.yun.reader.common.parse.ParseImpl;
import com.yun.reader.compent.conver.SpecialGsonConverterFactory;
import com.yun.reader.compent.http.RetrofitManager;
import com.yun.reader.compent.http.YunHttpHeaderInterceptor;
import com.yun.reader.compent.image.DisplayOption;
import com.yun.reader.compent.image.ImageShowImpl;
import com.yun.reader.compent.image.glide.GlideImageLoader;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

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

    @Singleton
    @Provides
    protected AssetManager provideAssetManager() {
        return application.getAssets();
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
    public RetrofitManager provideRetrofitManager(Retrofit retrofit) {
        RetrofitManager retrofitManager = new RetrofitManager(retrofit);
        return retrofitManager;
    }

    @Provides
    @Singleton
    public PersistentCookieJar provideCookJar() {
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
                .addInterceptor(new YunHttpHeaderInterceptor())
                .cookieJar(cookieJar);
        OkHttpClient okHttpClient;
        return okHttpClientBuilder.build();
    }

    @Provides
    @Singleton
    public ParseImpl provideJson() {
        return new GsonParse();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConfig.PROTOCOL_HTTPS + ApiConfig.BASE_HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SpecialGsonConverterFactory.create(GsonParse.initGson()))
                .build();
        return retrofit;
    }
}
