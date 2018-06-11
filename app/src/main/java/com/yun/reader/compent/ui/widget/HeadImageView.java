package com.yun.reader.compent.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.yun.reader.common.animan.AnimatorUtil;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/6/11 .
 * 邮箱 liulei@getui.com.
 */


public class HeadImageView extends ImageView {
    public HeadImageView(Context context) {
        this(context, null);
    }

    public HeadImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeadImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                AnimatorUtil.startScaleAnimator(HeadImageView.this);
                break;
            case MotionEvent.ACTION_UP:
                AnimatorUtil.startScaleAnimatorCancel(HeadImageView.this);
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }
}
