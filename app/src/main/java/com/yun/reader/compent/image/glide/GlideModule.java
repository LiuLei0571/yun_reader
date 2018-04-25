package com.yun.reader.compent.image.glide;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.target.ViewTarget;
import com.yun.reader.R;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/24 .
 * 邮箱:liulei@getui.com.
 */

@com.bumptech.glide.annotation.GlideModule
public final class GlideModule extends AppGlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        ViewTarget.setTagId(R.id.glide_tag_id);
        super.applyOptions(context, builder);
    }
}
