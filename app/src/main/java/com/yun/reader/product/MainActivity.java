package com.yun.reader.product;

import android.widget.TextView;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;

import javax.inject.Inject;

/**
 * @author liulei
 */
public class MainActivity extends TempleActivity {
    TextView mTx;
    @Inject
    MainPresenter presenter;

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }

}
