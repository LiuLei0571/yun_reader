package com.yun.reader.product.reader;

import com.yun.reader.R;
import com.yun.reader.compent.base.TempleActivity;
import com.yun.reader.compent.dagger.ActivityComponent;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public class ReaderActivity extends TempleActivity {
    @Override
    public int getLayoutView() {
        return R.layout.activity_reader_detail;
    }

    @Override
    public void doInject(ActivityComponent activityComponent) {
        activityComponent.plus(this);
    }
}
