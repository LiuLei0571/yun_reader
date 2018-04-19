package com.yun.reader.compent.dagger;

import com.yun.reader.compent.dagger.annotion.DialogScope;

import dagger.Subcomponent;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */

@DialogScope
@Subcomponent(modules = DialogModule.class)
public interface DialogComponent {
}
