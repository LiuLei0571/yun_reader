package com.yun.reader.common.storage;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/5/2 .
 * 邮箱:liulei@getui.com.
 */


public class StorageManager {
    private StorageType storageType;
    public static StorageManager storageManager;

    public static StorageManager getInstance(StorageType storageType) {
        if (storageManager == null) {
            synchronized (StorageManager.class) {
                if (storageManager == null) {
                    storageManager = new StorageManager();
                }
            }
        }
        return storageManager;
    }
}
