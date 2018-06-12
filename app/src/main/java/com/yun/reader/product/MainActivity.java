package com.yun.reader.product;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.product.splash.view.SplashActivity;
import com.yun.reader.product.splash.presenter.SelectGenderPresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author liulei
 */
public class MainActivity extends TempleActivity {
    TextView mTx;
    @Inject
    SelectGenderPresenter presenter;
    @BindView(R.id.tv_test)
    TextView tvTest;

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterLoadView(View mView) {
        super.afterLoadView(mView);
        presenter.loginAuto();
        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SplashActivity.class));

            }
        });
    }
    public void showLoginName(String userName) {
        tvTest.setText(userName);
    }
}
