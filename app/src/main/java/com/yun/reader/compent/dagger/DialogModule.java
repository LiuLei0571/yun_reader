package com.yun.reader.compent.dagger;

import com.yun.reader.compent.base.BaseDialog;

import dagger.Module;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */

@Module
public class DialogModule {
    private BaseDialog baseDialog;

    public DialogModule(BaseDialog baseDialog) {
        this.baseDialog = baseDialog;
    }
}
