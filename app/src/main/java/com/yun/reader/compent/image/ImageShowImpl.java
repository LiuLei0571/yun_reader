package com.yun.reader.compent.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.File;

/**
 * 用途：图片加载库公共类，方便灵活替换图片库.
 *
 * @author ：Created by liulei.
 * @date 2018/4/24 .
 * 邮箱:liulei@getui.com.
 */


public interface ImageShowImpl {
    int CACHE_IN_MEMORY = 1;
    int CACHE_IN_DISK = 2;

    File syncFile(String url);

    Drawable syncDrawable(String url);

    Bitmap syncBitmap(String url);

    void display(ImageView imageView, int bitmapId);

    void display(ImageView imageView, String url, DisplayOption displayOption, ImageLoadImpl imageLoadListener);

    void clearCache(int... cachePlace);

    void pause();

    void resume();

    void preLoad(String url);

}
