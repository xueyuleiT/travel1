package com.jtcxw.glcxw.base.utils;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
public class DeviceUtil {
    private static final String TAG = "DeviceIdUtils";
    private static final String KEY_NAME = "android_unique_device_id";//任意，但不能和系统设置冲突

    /**
     * 根据设备特征生成一个不变的设备id
     */
    @SuppressLint("MissingPermission")
    public static String getDeviceId(Context context) {
        Context applicationContext = context.getApplicationContext();
        String uniqueId = Settings.System.getString(applicationContext.getContentResolver(), KEY_NAME);
        if (!TextUtils.isEmpty(uniqueId)) {
            return uniqueId;
        } else if (!TextUtils.isEmpty(applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE).getString(TAG, ""))) {
            uniqueId = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE).getString(TAG, "");
            return uniqueId;
        }
        StringBuilder sb = new StringBuilder();


//        sb.append(UUID.randomUUID().toString());//随机生成UUID

        sb.append(Build.BOARD);//获取设备基板名称
        sb.append(Build.BOOTLOADER);//获取设备引导程序版本号
        sb.append(Build.BRAND);//获取设备品牌
        sb.append(Build.CPU_ABI);//获取设备指令集名称（CPU的类型）
        sb.append(Build.CPU_ABI2);//获取第二个指令集名称
        sb.append(Build.DEVICE);//获取设备驱动名称
        sb.append(Build.DISPLAY);//获取设备显示的版本包（在系统设置中显示为版本号）和ID一样
        sb.append(Build.FINGERPRINT);//设备的唯一标识。由设备的多个信息拼接合成。
        sb.append(Build.HARDWARE);//设备硬件名称,一般和基板名称一样（BOARD）
        sb.append(Build.ID);//设备版本号。
        sb.append(Build.MODEL);//获取手机的型号 设备名称。
        sb.append(Build.MANUFACTURER);//获取设备制造商
        sb.append(Build.PRODUCT);//整个产品的名称
        sb.append(Build.TAGS);//设备标签。如release-keys 或测试的 test-keys
        sb.append(Build.TYPE);//设备版本类型 主要为 "user" 或 "eng".
        sb.append(Build.USER);//设备用户名 基本上都为android -build
        sb.append(Build.VERSION.RELEASE);//获取系统版本字符串。如4.1.2 或2.2 或2.3等
        sb.append(Build.VERSION.CODENAME);//设备当前的系统开发代号，一般使用REL代替
        sb.append(Build.VERSION.INCREMENTAL);//系统源代码控制值，一个数字或者git hash值
        sb.append(Build.VERSION.SDK_INT);//系统的API级别 数字表示
        sb.append(Build.SERIAL);

        uniqueId = md5(sb.toString().trim().toUpperCase());
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            Settings.System.putString(applicationContext.getContentResolver(), KEY_NAME, uniqueId);
        } else {
            applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE).edit().putString(TAG, uniqueId).apply();
        }

        return uniqueId;
    }


    private static String md5(String str) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString().toUpperCase();
    }
}
