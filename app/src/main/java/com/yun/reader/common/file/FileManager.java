package com.yun.reader.common.file;

import android.support.v4.util.LruCache;

import com.yun.reader.common.helper.UserHelper;
import com.yun.reader.product.book.manager.ChapterResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

    public void createFileList(File file, String str) throws IOException {
        File[] listFiles = file.listFiles();
        for (File listFile : listFiles) {
            file1TransferFile2(listFile, new File(str, listFile.getName()));
        }
    }

    public void file1TransferFile2(File file, File file2) throws IOException {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        }
    }

    public boolean deleteFile(File file) {
        boolean z = false;
        if (file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteFile(file2);
                    } else {
                        z = file2.delete();
                    }
                }
                file.delete();
            }
        }
        return z;
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
