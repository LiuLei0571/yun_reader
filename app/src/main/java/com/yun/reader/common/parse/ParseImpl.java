package com.yun.reader.common.parse;

import java.lang.reflect.Type;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public interface ParseImpl {
    String toJson(Object bean);

    <T> T fromJson(String json, Class<T> clazz);

    <T> T fromJson(String json, Type type);
}
