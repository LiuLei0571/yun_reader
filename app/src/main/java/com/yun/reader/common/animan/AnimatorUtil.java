package com.yun.reader.common.animan;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.OvershootInterpolator;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/6/11 .
 * 邮箱 liulei@getui.com.
 */


public class AnimatorUtil {
    public static void startScaleAnimator(View mIvHead) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIvHead, "scaleX", 1, 1.2f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIvHead, "scaleY", 1, 1.2f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new OvershootInterpolator(3));
        set.playTogether(animatorX, animatorY);
        set.start();
    }

    public static void startScaleAnimatorCancel(View mIvHead) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIvHead, "scaleX", 1.2f, 1);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIvHead, "scaleY", 1.2f, 1);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new OvershootInterpolator(3));
        set.playTogether(animatorX, animatorY);
        set.start();
    }
}
