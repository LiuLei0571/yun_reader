package com.yun.reader.compent.dagger;

import com.yun.reader.product.MainActivity;
import com.yun.reader.compent.dagger.annotion.ActivityScope;

import dagger.Subcomponent;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 */
@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void plus(MainActivity activityComponent);
}
