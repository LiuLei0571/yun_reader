package com.yun.reader.common.helper;

import com.yun.reader.common.parse.ParseImpl;
import com.yun.reader.common.util.Strings;
import com.yun.reader.compent.dagger.ReaderControlHelper;

import java.lang.reflect.Type;

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

    public static <T> T fromJson(String json, Class<T> clzz) {
        return parse.fromJson(json, clzz);
    }

    public static <T> T fromJson(String json, Type type) {
        String typeString = Strings.EMPTY;
        if (type instanceof Class) {
            typeString = ((Class) type).getSimpleName();
        }
        if (isString(typeString)) {
            try {
                return (T) json;
            } catch (Throwable throwable) {
                return null;
            }
        }
        return parse.fromJson(json, type);
    }

    public static String toJsonString(Object bean) {
        return parse.toJson(bean);
    }

    private static boolean isString(String typeString) {
        return typeString.startsWith("String");
    }
}
