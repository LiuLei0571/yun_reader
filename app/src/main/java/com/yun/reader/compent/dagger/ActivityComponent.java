package com.yun.reader.compent.dagger;

import com.yun.reader.product.MainActivity;
import com.yun.reader.compent.dagger.annotion.ActivityScope;
import com.yun.reader.product.home.HomeActivity;
import com.yun.reader.product.splash.view.SelectGenderActivity;
import com.yun.reader.product.splash.view.SplashActivity;
import com.yun.reader.product.user.view.UserInfoActivity;

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

    void plus(SplashActivity splashActivity);

    void plus(UserInfoActivity userInfoActivity);

    void plus(SelectGenderActivity selectGenderActivity);

    void plus(HomeActivity homeActivity);
}
