package com.yun.reader.product.reader.activity;

import android.view.View;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;
import com.yun.reader.product.reader.presenter.ReaderDetailPresenter;

import javax.inject.Inject;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public class ReaderActivity extends TempleActivity {
    @Inject
    ReaderDetailPresenter presenter;
    @Override
    public int getLayoutView() {
        return R.layout.activity_reader_detail;
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

    @Override
    public void afterLoadView(View mView) {
        super.afterLoadView(mView);
        presenter.downloadChapterList("390780");
    }
}
