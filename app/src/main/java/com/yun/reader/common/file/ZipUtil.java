package com.yun.reader.common.file;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public class ZipUtil {
    public static boolean unzip(File file, String str) {
        try {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            new ZipFile(file.getAbsolutePath()).extractAll(str);
            return true;
        } catch (ZipException e) {
            e.printStackTrace();
            return false;
        }
    }
}
