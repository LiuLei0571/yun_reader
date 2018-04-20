package com.yun.reader.compent.base;

import android.os.Bundle;

import com.yun.reader.compent.base.impl.ViewImpl;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 */


public class BasePresenter<T extends ViewImpl> extends BaseViewPresenter {

    public BasePresenter(ViewImpl iView) {
        super(iView);
        iView.saveCurrentPresenter(this);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void doCreate(Bundle savedInstanceState, Bundle params) {
        if (params != null) {
            initParams(params);
        }
        onCreate(savedInstanceState);
    }

    public void initParams(Bundle params) {
    }

    public void onCreate(Bundle savedInstanceState) {
    }
}
