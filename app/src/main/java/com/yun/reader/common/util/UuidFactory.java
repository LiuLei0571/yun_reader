package com.yun.reader.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.UUID;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/28 .
 * 邮箱:liulei@getui.com.
 */


public class UuidFactory {
    public static UUID uuid;

    @SuppressLint({"MissingPermission", "HardwareIds", "WrongConstant"})
    public static UUID getUUId(Context context) {
        if (null==uuid) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("device_id.xml", 0);
            String string = sharedPreferences.getString("device_id", null);
            if (string != null) {
                uuid = UUID.fromString(string);
            } else {
                string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                try {
                    if ("9774d56d682e549c".equals(string)) {
                        UUID nameUUIDFromBytes;
                        string = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        if (string != null) {
                            nameUUIDFromBytes = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
                        } else {
                            nameUUIDFromBytes = UUID.randomUUID();
                        }
                        uuid = nameUUIDFromBytes;
                    } else {
                        uuid = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
                    }
                    sharedPreferences.edit().putString("device_id", uuid.toString()).commit();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return uuid;
    }
}
