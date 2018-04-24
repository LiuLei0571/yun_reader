package com.yun.reader.compent.base;

import com.yun.reader.compent.base.impl.LoadingImpl;
import com.yun.reader.compent.base.impl.ViewImpl;

import javax.inject.Inject;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/20 .
 * 邮箱:liulei@getui.com.
 */


public class BaseViewPresenter<T extends ViewImpl> {
    protected T view;
    @Inject
    BaseActivity baseActivity;

    protected BaseViewPresenter(ViewImpl view) {
        this.view = (T) view;
    }

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

    protected BaseActivity getBaseActivity() {
        return baseActivity;
    }

    public void setBaseActivity(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    public void showLoading() {
        baseActivity.showLoading();
    }

    public void showLoading(String loadingDesc) {
        baseActivity.showLoading(loadingDesc);
    }

    public LoadingImpl getLoadingImpl() {
        return baseActivity;
    }

    public void finish() {
        baseActivity.finish();
    }
}

