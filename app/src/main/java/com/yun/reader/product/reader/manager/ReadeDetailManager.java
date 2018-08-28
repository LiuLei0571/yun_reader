package com.yun.reader.product.reader.manager;

import com.yun.reader.compent.base.BaseManager;
import com.yun.reader.compent.http.CommonObserver;

import java.util.Map;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public class ReadeDetailManager extends BaseManager {
    public void downloadChaptersList(String bookId, CommonObserver commonObserver) {
        Map params = getParamsMap();
        params.put("bookId", bookId);
        handlerObserver(retrofitApis.downloadChapterList(params), commonObserver);
    }

    public void downloadChapters(String bookId, String[] chapterIndexes, CommonObserver commonObserver) {
        Map params = getParamsMap();
        params.put("updateTime", System.currentTimeMillis());
        params.put("bookId", bookId);
        params.put("chapterIndexes", chapterIndexes);
        handlerObserver(retrofitApis.downloadChapters(params), commonObserver);
    }
}
