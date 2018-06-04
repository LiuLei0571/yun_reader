package com.yun.reader.compent.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yun.reader.compent.base.impl.LoadingImpl;
import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.compent.dagger.ReaderControl;

import butterknife.ButterKnife;

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

        if (presenterControl == null) {
            presenterControl = new PresenterControl();
        }
        if (activityComponent == null) {
            activityComponent = ReaderControl.createActivityComponent(this);
        }
        doInject(activityComponent);
        View mView = getLayoutInflater().inflate(getLayoutView(), null, false);
        beforeLoadView();
        setContentView(mView);
        bindView(mView);
        initParam(getIntent().getExtras());
        afterLoadView(mView);
        presenterControl.bind(savedInstanceState, getIntent().getExtras());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public abstract void doInject(ActivityComponent activityComponent);

    @Override
    public void saveCurrentPresenter(BasePresenter basePresenter) {
        if (basePresenter != null) {
            presenterControl.savePresenter(basePresenter);
        }
    }

    protected void initParam(Bundle bundle) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenterControl != null) {
            presenterControl.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenterControl != null) {
            presenterControl.onDestroy();
            presenterControl = null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (presenterControl != null) {
            presenterControl.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void bindView(View mView) {
        ButterKnife.bind(this, mView);

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
