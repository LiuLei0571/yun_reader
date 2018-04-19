package com.yun.reader.product;

import android.os.Bundle;
import android.widget.TextView;

import com.yun.reader.R;
import com.yun.reader.compent.base.BaseActivity;
import com.yun.reader.compent.dagger.ActivityComponent;

import javax.inject.Inject;

/**
 * @author liulei
 */
public class MainActivity extends BaseActivity {
    TextView mTx;
    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTx = findViewById(R.id.tv_test);
        mTx.setText(presenter.getStr());
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }
}
