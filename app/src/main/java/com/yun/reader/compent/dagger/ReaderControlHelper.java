package com.yun.reader.compent.dagger;

import com.yun.reader.common.parse.ParseImpl;
import com.yun.reader.compent.http.RetrofitManager;
import com.yun.reader.compent.image.ImageShowImpl;

import javax.inject.Inject;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/25 .
 * 邮箱:liulei@getui.com.
 */


public class ReaderControlHelper {
    @Inject
    public ImageShowImpl imageShow;
    @Inject
    public RetrofitManager retrofitManager;
    @Inject
    public ParseImpl parse;

    private static ReaderControlHelper readerControlHelper;

    public static ReaderControlHelper getInstance() {
        if (readerControlHelper == null) {
            synchronized (ReaderControlHelper.class) {
                if (readerControlHelper == null) {
                    readerControlHelper = new ReaderControlHelper();
                }
            }
        }
        return readerControlHelper;
    }

    public ReaderControlHelper() {
        ReaderControl.getReaderComponent().plus(this);
    }
}
