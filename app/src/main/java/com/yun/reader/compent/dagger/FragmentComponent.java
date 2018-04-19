package com.yun.reader.compent.dagger;


import android.support.v4.app.Fragment;

import com.yun.reader.compent.dagger.annotion.FragmentScope;

import dagger.Subcomponent;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */
@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(Fragment fragmentComponent);
}
