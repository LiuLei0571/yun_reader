package com.yun.reader.common.helper;

import com.yun.reader.common.file.FileManager;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public class FileHelper {
    private static FileManager fileManager;

    public static FileManager getInstance() {
        if (fileManager == null) {
            synchronized (FileManager.class) {
                if (fileManager == null) {
                    fileManager = new FileManager();
                }
            }
        }
        return fileManager;
    }
    public void initFolder(){
        fileManager.createFolder();
    }
}
