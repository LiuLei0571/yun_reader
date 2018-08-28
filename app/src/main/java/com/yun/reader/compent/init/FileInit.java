package com.yun.reader.compent.init;

import android.content.Context;

import com.yun.reader.common.helper.FileHelper;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public class FileInit implements AppInitImpl {
    @Override
    public void init(Context context) {
        FileHelper.getInstance().createFolder();
    }
}
