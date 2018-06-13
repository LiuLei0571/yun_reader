package com.yun.reader.product.home;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/6/12 .
 * 邮箱 liulei@getui.com.
 */


public class HomeActivity extends TempleActivity {
    @Override
    public int getLayoutView() {
        return R.layout.activity_home;
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }
}
