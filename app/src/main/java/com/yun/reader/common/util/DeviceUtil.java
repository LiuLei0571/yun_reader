package com.yun.reader.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import com.yun.reader.YunApplication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/28 .
 * 邮箱:liulei@getui.com.
 */


public class DeviceUtil {
    public final static String PLATFORM = "Android";

    public static String getPlatForm() {
        return PLATFORM;
    }

    public static String getPackageId() {
        String packageId = "";
        try {
            if (getPackageInfo() != null) {
                packageId = String.valueOf(getPackageInfo().versionCode);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return packageId;
    }

    private static PackageInfo getPackageInfo() {
        try {
            return YunApplication.appContext.getPackageManager().getPackageInfo(YunApplication.appContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getChannelCode() {
        String str = "channel.txt";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream open = YunApplication.appContext.getApplicationContext().getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine + "\n");
            }
            bufferedReader.close();
            open.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String getDeviceId() {
        UUID uuid = UuidFactory.getUUId(YunApplication.appContext);

        return uuid != null ? uuid.toString() : "";
    }

    @SuppressLint({"WrongConstant", "MissingPermission"})
    public static String getIMEI() {
        if (isPermissionWithStringValided(YunApplication.appContext, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager phone = (TelephonyManager) YunApplication.getAppContext().getApplicationContext().getSystemService("phone");
            if (phone != null) {
                return phone.getDeviceId();
            }
        }
        return "";
    }

    public static String getMAC() {
        return getWifiAddress();
    }

    public static String getDeviceSdk() {

        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getAid() {
        try {
            return Settings.Secure.getString(YunApplication.appContext.getContentResolver(), "android_id");

        } catch (Throwable throwable) {

        }
        return "";
    }

    @SuppressLint("WrongConstant")

    public static boolean isPermissionWithStringValided(Context context, String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                boolean z;
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{permission})).intValue() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } catch (Exception e) {
                return false;
            }
        } else {
            return context.getPackageManager().checkPermission(permission, context.getPackageName()) == 0;
        }
    }

    private static String getWifiAddress() {
        String macAddress = ((WifiManager) YunApplication.appContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        try {
            URLEncoder.encode(macAddress, "UTF-8");
            if (macAddress == null) {
                return "";
            }
            if ("02:00:00:00:00:00".equals(macAddress)) {
                macAddress = getSocketAddress();

            }
            if (macAddress == null) {
                macAddress = "";
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return macAddress;
    }

    private static String getSocketAddress() throws SocketException {
        Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
        HashMap hashMap = new HashMap<>();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                StringBuilder stringBuilder = new StringBuilder();
                int length = hardwareAddress.length;
                for (int i = 0; i < length; i++) {
                    stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                hashMap.put(networkInterface.getName(), stringBuilder.toString());
            }
        }
        if (hashMap.containsKey("wlan0")) {
            return (String) hashMap.get("wlan0");
        }
        if (hashMap.containsKey("dummy0")) {
            return (String) hashMap.get("dummy0");
        }
        if (hashMap.containsKey("usb0")) {
            return (String) hashMap.get("usb0");
        }
        return "";
    }

}
