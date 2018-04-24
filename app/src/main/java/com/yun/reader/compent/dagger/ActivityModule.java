package com.yun.reader.compent.dagger;

import android.content.Context;

import com.yun.reader.compent.base.BaseActivity;
import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.dagger.annotion.ActivityScope;

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
public class ActivityModule {
    private final BaseActivity mActivity;

    public ActivityModule(BaseActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityScope
    public Context provideContext() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    public BaseActivity provideBaseActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    public ViewImpl provideViewImpl() {
        return mActivity;
    }
}
