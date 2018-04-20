package com.yun.reader.compent.base.impl;

import android.view.View;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/20 .
 * 邮箱:liulei@getui.com.
 */


public interface ViewImpl {
    void beforeLoadView();

    void bindView(View mView);

    int getLayoutView();

    void afterLoadView();

    void unBindView();
}
