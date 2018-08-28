package com.yun.reader.product.home;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.product.reader.ReaderActivity;

import butterknife.BindView;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/6/12 .
 * 邮箱 liulei@getui.com.
 */


public class HomeActivity extends TempleActivity {
    @BindView(R.id.btn_reading_detail)
    Button btnReadingDetail;

    @Override
    public int getLayoutView() {
        return R.layout.activity_home;
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterLoadView(View mView) {
        super.afterLoadView(mView);
        btnReadingDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ReaderActivity.class));
            }
        });
    }
}
