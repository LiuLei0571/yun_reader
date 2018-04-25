package com.yun.reader.compent.image.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.yun.reader.common.hellper.ThreadHelper;
import com.yun.reader.common.util.StringUtils;
import com.yun.reader.compent.image.DisplayOption;
import com.yun.reader.compent.image.ImageLoadImpl;
import com.yun.reader.compent.image.ImageShowImpl;

import java.io.File;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/25 .
 * 邮箱:liulei@getui.com.
 */


public class GlideImageLoader implements ImageShowImpl {
    private Context context;
    private DisplayOption displayOption;

    public GlideImageLoader(Context context) {
        this.context = context;
    }

    public void setGlideImage(DisplayOption displayOption) {
        this.displayOption = displayOption;
    }

    @Override
    public File syncFile(String url) {
        if (StringUtils.isStringEmpty(url)) {
            return null;
        }
        try {
            return GlideApp.with(context).asFile().load(url).submit().get();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Drawable syncDrawable(String url) {
        if (StringUtils.isStringEmpty(url)) {
            return null;
        }
        try {
            return GlideApp.with(context).asDrawable().load(url).submit().get();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Bitmap syncBitmap(String url) {
        if (StringUtils.isStringEmpty(url)) {
            return null;
        }
        try {
            return GlideApp.with(context).asBitmap().load(url).submit().get();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void display(ImageView imageView, int bitmapId) {
        GlideApp.with(context).asBitmap().load(bitmapId).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);

    }

    @Override
    public void display(ImageView imageView, String url, DisplayOption customDisplayOption, final ImageLoadImpl imageLoadListener) {
        GlideRequest glideRequest = GlideApp.with(context).load(url);
        displayOption = customDisplayOption == null ? displayOption : customDisplayOption;
        if (displayOption != null) {
            if (displayOption.errorResId > 0) {
                glideRequest.error(displayOption.errorResId);
            }
            if (displayOption.defaultResId > 0) {
                glideRequest.placeholder(displayOption.defaultResId);
            }
            if (displayOption.loadingResId > 0) {
                glideRequest.placeholder(displayOption.loadingResId);
            }
            glideRequest.skipMemoryCache(displayOption.cacheInMemory);
            if (displayOption.cacheOnDisk) {
                glideRequest.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
            } else {
                glideRequest.diskCacheStrategy(DiskCacheStrategy.NONE);
            }
            if (displayOption.maxHeight != null && displayOption.maxWidth != null) {
                glideRequest.override(displayOption.maxWidth, displayOption.maxHeight);
            }
        }
        if (imageLoadListener != null) {
            glideRequest.listener(new RequestListener<Bitmap>() {
                @Override
                public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                    imageLoadListener.onSuccess(resource);
                    return false;
                }

                @Override
                public boolean onLoadFailed(@Nullable GlideException exception, Object model, Target target, boolean isFirstResource) {
                    imageLoadListener.onFail(exception);
                    return false;
                }
            });
        }
        GlideApp.with(context).load(url).into(imageView);
    }


    @Override
    public void clearCache(int... cachePlace) {
        if (cachePlace.length > 0) {
            for (int place : cachePlace) {
                switch (place) {
                    case CACHE_IN_MEMORY:
                        if (ThreadHelper.isHandleInMain()) {
                            ThreadHelper.postMainHandler(new Runnable() {
                                @Override
                                public void run() {
                                    GlideApp.get(context).clearMemory();
                                }
                            });
                        } else {
                            GlideApp.get(context).clearMemory();
                        }
                        break;
                    case CACHE_IN_DISK:
                        if (ThreadHelper.isHandleInMain()) {
                            GlideApp.get(context).clearDiskCache();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void pause() {
        GlideApp.with(context).pauseRequests();
    }

    @Override
    public void resume() {
        GlideApp.with(context).resumeRequests();
    }

    @Override
    public void preLoad(final String url) {
        if (ThreadHelper.isHandleInMain()) {
            ThreadHelper.postMainHandler(new Runnable() {
                @Override
                public void run() {
                    GlideApp.with(context).asBitmap().load(url).preload();
                }
            });
        } else {
            GlideApp.with(context).asBitmap().load(url).preload();

        }
    }
}
