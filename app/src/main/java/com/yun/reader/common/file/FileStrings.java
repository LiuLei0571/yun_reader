package com.yun.reader.common.file;

import android.os.Environment;

import net.lingala.zip4j.util.InternalZipConstants;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public interface FileStrings {
    public String BASE_ROOT = (Environment.getExternalStorageDirectory().getAbsolutePath() + InternalZipConstants.ZIP_FILE_SEPARATOR);
    public String BASE_YUN = (BASE_ROOT + ".yun_novel/");
    public String CACHE = (BASE_YUN + "cache/");
    public String TEMPLE = (CACHE + "temp/");
    public String OFFLINE_PACK = (CACHE + "offlinePack/");
    public String ONLINE = (BASE_YUN + "online/");
    public String COVER = (BASE_YUN + "cover/");
    public String LOCAL = (BASE_YUN + "local/");
    public String APK = (BASE_YUN + "apk/");
    public String FONT = (BASE_YUN + "font/");
    public String LOG = (BASE_YUN + "log/");
    public String APP_LOG = (BASE_YUN + "app_log/");
    public String DOWNLOAD = (BASE_YUN + "download/");
    public String PURCHASED_CHAPTERS = (BASE_YUN + "purchasedChapters/");
    public String[] ALL_FOLDER_NAME = {CACHE, TEMPLE, OFFLINE_PACK, ONLINE, COVER, LOCAL, APK, FONT, LOG, APP_LOG, DOWNLOAD, PURCHASED_CHAPTERS};
}
