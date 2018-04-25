package com.yun.reader.compent.dagger;

import android.content.Context;

import com.yun.reader.compent.image.DisplayOption;
import com.yun.reader.compent.image.ImageShowImpl;
import com.yun.reader.compent.image.glide.GlideImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
}
