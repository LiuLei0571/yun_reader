package com.yun.reader.common.schedule;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/30 .
 * 邮箱 liulei@getui.com.
 */


public interface CountdownListener {
    void onFinsh();

    void onError(Throwable throwable);
}
