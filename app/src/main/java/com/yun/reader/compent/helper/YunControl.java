package com.yun.reader.compent.helper;

import android.content.Context;

import com.yun.reader.compent.base.BaseActivity;
import com.yun.reader.compent.base.BaseDialog;
import com.yun.reader.compent.base.BaseFragment;
import com.yun.reader.compent.base.BaseService;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.compent.dagger.ActivityModule;
import com.yun.reader.compent.dagger.AppComponent;
import com.yun.reader.compent.dagger.AppModule;
import com.yun.reader.compent.dagger.DaggerAppComponent;
import com.yun.reader.compent.dagger.DialogComponent;
import com.yun.reader.compent.dagger.DialogModule;
import com.yun.reader.compent.dagger.FragmentComponent;
import com.yun.reader.compent.dagger.FragmentModule;
import com.yun.reader.compent.dagger.ServiceComponent;
import com.yun.reader.compent.dagger.ServiceModule;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public class YunControl {
    private static AppComponent appComponent;

    public static void init(Context context) {
        AppModule appModule = new AppModule(context);
        appComponent = DaggerAppComponent.builder().build();
    }

    public static ActivityComponent createActivityComponent(BaseActivity activity) {
        return appComponent.plus(new ActivityModule(activity));
    }

    public static ServiceComponent createServiceComponent(BaseService baseService) {
        return appComponent.plus(new ServiceModule(baseService));
    }

    public static FragmentComponent createFragmentComponent(BaseFragment baseFragment) {
        return appComponent.plus(new FragmentModule(baseFragment));
    }

    public static DialogComponent createDialogComponent(BaseDialog baseDialog) {
        return appComponent.plus(new DialogModule(baseDialog));
    }
}
