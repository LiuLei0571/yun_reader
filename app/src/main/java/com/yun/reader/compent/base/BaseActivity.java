package com.yun.reader.compent.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yun.reader.compent.base.impl.LoadingImpl;
import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.compent.helper.YunControl;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 */


public abstract class BaseActivity extends Activity implements ViewImpl, LoadingImpl {
    private ActivityComponent activityComponent;
    private PresenterControl presenterControl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        if (activityComponent == null) {
            activityComponent = YunControl.createActivityComponent(this);
        }
        if (presenterControl == null) {
            presenterControl = new PresenterControl();
        }
        View mView = getLayoutInflater().inflate(getLayoutView(), null, false);
        beforeLoadView();
        setContentView(mView);
        bindView(mView);
        afterLoadView(mView);
        doInject(activityComponent);
        presenterControl.bind(savedInstanceState,getIntent().getExtras());

    }

    public abstract void doInject(ActivityComponent activityComponent);

    @Override
    public void saveCurrentPresenter(BasePresenter basePresenter) {
        if (basePresenter != null) {
            presenterControl.savePresenter(basePresenter);
        }
    }

    @Override
    public void bindView(View mView) {

    }

    @Override
    public void unBindView() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoading(String loadDesc) {

    }

    @Override
    public void dismissLoading() {

    }
}
