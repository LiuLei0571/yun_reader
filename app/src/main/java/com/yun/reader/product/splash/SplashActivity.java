package com.yun.reader.product.splash;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/23 .
 * 邮箱:liulei@getui.com.
 */


public class SplashActivity extends TempleActivity {
    @Override
    public int getLayoutView() {
        return R.layout.activity_splash;
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }
}
