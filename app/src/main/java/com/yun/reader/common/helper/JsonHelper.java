package com.yun.reader.common.helper;

import com.yun.reader.common.parse.ParseImpl;
import com.yun.reader.compent.dagger.ReaderControlHelper;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class JsonHelper {
    public static ParseImpl parse;

    static {
        parse = ReaderControlHelper.getInstance().parse;
    }
}
