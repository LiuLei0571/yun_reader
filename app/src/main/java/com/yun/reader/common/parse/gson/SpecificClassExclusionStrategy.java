package com.yun.reader.common.parse.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/6/12 .
 * 邮箱 liulei@getui.com.
 */


public class SpecificClassExclusionStrategy implements ExclusionStrategy {
    private Class<?> excludedThisClass;
    private Class<?> excludedThisClassFields;

    public SpecificClassExclusionStrategy(Class<?> excludedThisClass, Class<?> excluedThisClassFields) {
        this.excludedThisClass = excludedThisClass;
        this.excludedThisClassFields = excluedThisClassFields;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getDeclaringClass().equals(excludedThisClassFields);
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return clazz != null && (clazz.equals(excludedThisClass) || shouldSkipClass(clazz.getSuperclass()));
    }
}
