package com.yun.reader.compent.base;

import android.content.Intent;
import android.os.Bundle;

import com.yun.reader.compent.base.impl.ViewImpl;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 */


public class BasePresenter<T extends ViewImpl> extends BaseViewPresenter<T> {

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
        if (params == null) {
            params = new Bundle();
        }
        initParams(params);

        onCreate(savedInstanceState);
    }

    protected void initParams(Bundle params) {
    }

    protected void onCreate(Bundle savedInstanceState) {
    }

    protected void onResume() {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    protected void onDestroy() {

    }
}
