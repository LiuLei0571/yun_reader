package com.yun.reader.product;

import com.yun.reader.compent.base.BasePresenter;

import javax.inject.Inject;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public class MainPresenter extends BasePresenter {
    String str;
    @Inject
    public MainPresenter() {
        str="hello world";
    }

    public String getStr() {
        return str;
    }
}
