package com.yun.reader.compent.image.glide;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

/**
 * 用途glide图片预处理，实现全局圆角功能.
 *
 * @author ：Created by liulei.
 * @date 2018/4/25 .
 * 邮箱:liulei@getui.com.
 */


public class CornersTransform extends BitmapTransformation {
    private double radius;

    public CornersTransform(double radius) {
        this.radius = radius;
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {

        return null;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {

    }
}
