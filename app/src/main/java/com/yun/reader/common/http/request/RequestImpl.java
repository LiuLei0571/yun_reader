package com.yun.reader.common.http.request;

import java.util.Map;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/26 .
 * 邮箱:liulei@getui.com.
 */


public interface RequestImpl {
    Map<String, Object> getParams();

    Object getDefaultObject();

    Map<String, String> getHeaders();
}
