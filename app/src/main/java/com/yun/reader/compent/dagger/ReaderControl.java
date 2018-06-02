package com.yun.reader.compent.dagger;

import android.content.Context;

import com.yun.reader.compent.base.BaseActivity;
import com.yun.reader.compent.base.BaseDialog;
import com.yun.reader.compent.base.BaseFragment;
import com.yun.reader.compent.base.BaseService;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public class ReaderControl {
    private static ReaderComponent readerComponent;

    public static void init(Context context) {
        ReaderModule readerModule = new ReaderModule(context);
        ManagerModule managerModule = new ManagerModule();
        readerComponent = DaggerReaderComponent.builder()
                .readerModule(readerModule)
                .managerModule(managerModule)
                .build();
    }

    public static ReaderComponent getReaderComponent() {
        return readerComponent;
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
