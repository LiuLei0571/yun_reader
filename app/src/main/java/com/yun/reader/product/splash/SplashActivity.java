package com.yun.reader.product.splash;

import android.content.Intent;
import android.view.View;

import com.yun.reader.R;
import com.yun.reader.common.helper.ThreadHelper;
import com.yun.reader.common.helper.UserHelper;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.product.MainActivity;

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

    @Override
    public void afterLoadView(View mView) {
        super.afterLoadView(mView);
        ThreadHelper.postMainHandlerDelay(new Runnable() {
            @Override
            public void run() {
                firstStartApp();
            }
        }, 1500);
    }

    private void firstStartApp() {
        if (UserHelper.getUserInfo() == null) {
            startActivity(new Intent(this, SelectGenderActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
        finish();
    }
}
