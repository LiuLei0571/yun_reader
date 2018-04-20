package com.yun.reader.compent.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.compent.helper.YunControl;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 */


public abstract class BaseActivity extends Activity implements ViewImpl {
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        if (activityComponent == null) {
            activityComponent = YunControl.createActivityComponent(this);
        }
        doInject(activityComponent);

    }

    public abstract void doInject(ActivityComponent activityComponent);

    @Override
    public void bindView(View mView) {

    }

    @Override
    public void unBindView() {

    }
}
