package com.yun.reader.common.file;

import android.support.v4.util.LruCache;

import com.yun.reader.common.helper.UserHelper;
import com.yun.reader.product.book.manager.ChapterResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public class FileManager {
    LruCache<String, List<ChapterResponse>> chapterParams = new LruCache(2);

    public void deleteFileByBookId(String str) {
        removeCache(str);
        File file = new File(getOnlineRootPathJson(str));
        if (file.exists()) {
            file.delete();
        }
    }

    public void removeCache(String str) {
        if (chapterParams != null) {
            chapterParams.remove(str);
        }
    }

    public String getOnlineRootPath(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FileStrings.ONLINE)
                .append(UserHelper.getUserInfo().getUserId())
                .append(File.separator)
                .append(str);
        return stringBuilder.toString();
    }

    public String getOnlineRootPathJson(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FileStrings.ONLINE)
                .append(UserHelper.getUserInfo().getUserId())
                .append(File.separator)
                .append(str)
                .append(File.separator)
                .append("ChaptersList.json");
        return stringBuilder.toString();
    }

    public void createFolder() {
        for (String filePath : FileStrings.ALL_FOLDER_NAME) {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    public boolean downFile(ResponseBody responseBody, String str, String str2) throws Throwable {
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                file.deleteOnExit();
            }
            file.createNewFile();
            InputStream byteStream;
            OutputStream fileOutputStream;
            try {
                byte[] bArr = new byte[4096];
                responseBody.contentLength();
                long j = 0;
                byteStream = responseBody.byteStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            j += (long) read;
                        } catch (IOException e) {
                            outputStream = fileOutputStream;
                            inputStream = byteStream;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    fileOutputStream.flush();
                    if (byteStream != null) {
                        byteStream.close();
                    }
                    if (fileOutputStream == null) {
                        return true;
                    }
                    fileOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    inputStream = byteStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    fileOutputStream = null;
                    th = th4;
                    if (byteStream != null) {
                        byteStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                inputStream = null;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return false;
            } catch (Throwable th32) {
                byteStream = null;
                th = th32;
                fileOutputStream = null;
                if (byteStream != null) {
                    byteStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e4) {
            return false;
        }
    }

}
