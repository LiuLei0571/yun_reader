package com.yun.reader.product;

import android.view.View;
import android.widget.TextView;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author liulei
 */
public class MainActivity extends TempleActivity {
    TextView mTx;
    @Inject
    MainPresenter presenter;
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
        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData();

            }
        });
    }
}
