package com.yun.reader.compent.helper;

import android.widget.ImageView;

import com.yun.reader.compent.dagger.ReaderControlHelper;
import com.yun.reader.compent.image.DisplayOption;
import com.yun.reader.compent.image.ImageLoadImpl;
import com.yun.reader.compent.image.ImageShowImpl;

/**
 * 用途：图片帮助工具类.
 *
 * @author ：Created by liulei.
 * @date 2018/4/24 .
 * 邮箱:liulei@getui.com.
 */


public class ImageHelper {
    private static ImageShowImpl imageShow;

    static {
        if (imageShow == null) {
            imageShow = ReaderControlHelper.getInstance().imageShow;
        }
    }

    public static void display(ImageView imageView, String url) {
        display(imageView, url, null, null);
    }

    public static void display(ImageView imageView, String url, DisplayOption displayOption) {
        display(imageView, url, displayOption, null);
    }

    public static void display(ImageView imageView, String url, DisplayOption displayOption, ImageLoadImpl imageLoadListener) {
        imageShow.display(imageView, url, displayOption, imageLoadListener);
    }

    public static void display(ImageView imageView, String url, ImageLoadImpl imageLoadListener) {
        display(imageView, url, null, imageLoadListener);
    }

}
