package com.yun.reader.common.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.yun.reader.YunApplication;
import com.yun.reader.common.helper.JsonHelper;

import java.lang.reflect.Type;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class Sps {
    private String SPS_KEY = "m.zhulang.sp";
    private SharedPreferences sharedPreferences;

    public Sps() {
        sharedPreferences = YunApplication.appContext.getSharedPreferences(SPS_KEY, Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public <T> void put(String key, T value) {
        if (value == null || sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (editor != null) {
            if (value instanceof String) {
                editor.putString(key, (String) value);
            } else if (value instanceof Integer) {
                editor.putInt(key, (Integer) value);
            } else if (value instanceof Boolean) {
                editor.putBoolean(key, (Boolean) value);
            } else if (value instanceof Long) {
                editor.putLong(key, (Long) value);
            } else if (value instanceof Float) {
                editor.putFloat(key, (Float) value);
            } else {
                editor.putString(key, value.toString());
            }
            editor.apply();
        }
    }

    public void putBean(String key, Object object) {
        sharedPreferences.edit().putString(key, JsonHelper.toJsonString(object));

    }

    public <T> T getBean(String key, Type type) {
        String json = sharedPreferences.getString(key, null);
        return JsonHelper.fromJson(json, type);
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public Integer getInteger(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public Long getLong(String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public Float getFloat(String key) {
        return sharedPreferences.getFloat(key, 0);
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }
}
