package com.yun.reader.compent.helper;

import android.content.Context;

import com.yun.reader.compent.base.BaseActivity;
import com.yun.reader.compent.base.BaseDialog;
import com.yun.reader.compent.base.BaseFragment;
import com.yun.reader.compent.base.BaseService;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.compent.dagger.ActivityModule;
import com.yun.reader.compent.dagger.DaggerReaderComponent;
import com.yun.reader.compent.dagger.ReaderComponent;
import com.yun.reader.compent.dagger.ReaderModule;
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
    private static ReaderComponent readerComponent;

    public static void init(Context context) {
        ReaderModule readerModule = new ReaderModule(context);
        readerComponent = DaggerReaderComponent.builder().readerModule(readerModule).build();
    }

    public static ActivityComponent createActivityComponent(BaseActivity activity) {
        return readerComponent.plus(new ActivityModule(activity));
    }

    public static ServiceComponent createServiceComponent(BaseService baseService) {
        return readerComponent.plus(new ServiceModule(baseService));
    }

    public static FragmentComponent createFragmentComponent(BaseFragment baseFragment) {
        return readerComponent.plus(new FragmentModule(baseFragment));
    }

    public static DialogComponent createDialogComponent(BaseDialog baseDialog) {
        return readerComponent.plus(new DialogModule(baseDialog));
    }
}
