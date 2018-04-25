package com.yun.reader.compent.image;

import android.graphics.Bitmap;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/25 .
 * 邮箱:liulei@getui.com.
 */


public interface ImageLoadImpl {
    void onSuccess(Bitmap drawable);

    void onFail(Throwable throwable);
}
