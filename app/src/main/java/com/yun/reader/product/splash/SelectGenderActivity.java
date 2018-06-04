package com.yun.reader.product.splash;

import android.view.View;
import android.widget.ImageView;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.compent.helper.ImageHelper;

import butterknife.BindView;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/30 .
 * 邮箱 liulei@getui.com.
 */


public class SelectGenderActivity extends TempleActivity {
    @BindView(R.id.iv)
    ImageView iv;

    @Override
    public int getLayoutView() {
        return R.layout.activity_select_gender;
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterLoadView(View mView) {
        super.afterLoadView(mView);
        ImageHelper.display(iv, "http://img.zcool.cn/community/01690955496f930000019ae92f3a4e.jpg@2o.jpg");
    }

}
