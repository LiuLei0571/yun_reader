package com.yun.reader.compent.base;

import com.yun.reader.compent.helper.HttpHelper;
import com.yun.reader.compent.http.CommonObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/27 .
 * 邮箱:liulei@getui.com.
 */


public class BaseManager {
    public void execute(CommonObserver commonObserver) {
        Map<String, Object> params = new HashMap<>();
        params.put("via", "auto");
        HttpHelper.execute(commonObserver, params);
    }

}
