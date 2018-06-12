package com.yun.reader.product.splash.view;

import android.view.View;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.compent.ui.widget.HeadImageView;
import com.yun.reader.product.splash.presenter.SelectGenderPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/30 .
 * 邮箱 liulei@getui.com.
 */


public class SelectGenderActivity extends TempleActivity {

    @BindView(R.id.iv_header_man)
    HeadImageView ivHeaderMan;
    @BindView(R.id.iv_header_woman)
    HeadImageView ivHeaderWoman;
    @Inject
    SelectGenderPresenter mPresenter;

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
        login();
    }

    @OnClick({R.id.iv_header_man, R.id.iv_header_woman})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_header_man:
                login();
                break;
            case R.id.iv_header_woman:
                break;
            default:
                break;

        }
    }

    private void login() {
        mPresenter.loginAuto();
    }
}
