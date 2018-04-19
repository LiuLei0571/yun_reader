package com.yun.reader.compent.init;

import android.content.Context;

import com.yun.reader.compent.helper.YunControl;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public class FrameWorkInit implements AppInitImpl {
    @Override
    public void init(Context context) {
        YunControl.init(context);
    }

}
