package com.yun.reader.product;

import com.yun.reader.compent.base.BaseManager;
import com.yun.reader.compent.http.CommonObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/28 .
 * 邮箱:liulei@getui.com.
 */


public class MainManager extends BaseManager {
    public void loginAuto(CommonObserver commonObserver) {
        Map<String, Object> params = new HashMap<>();
        params.put("via", "auto");
        handlerObserver(retrofitApis.login(params), commonObserver);
    }
}
