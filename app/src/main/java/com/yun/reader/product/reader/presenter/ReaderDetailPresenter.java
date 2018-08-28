package com.yun.reader.product.reader.presenter;

import android.widget.Toast;

import com.yun.reader.common.file.FileStrings;
import com.yun.reader.common.file.ZipUtil;
import com.yun.reader.common.helper.FileHelper;
import com.yun.reader.common.helper.UserHelper;
import com.yun.reader.common.http.response.ResultResponse;
import com.yun.reader.compent.base.BasePresenter;
import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.http.CommonObserver;
import com.yun.reader.product.reader.activity.ReaderActivity;
import com.yun.reader.product.reader.manager.ReadeDetailManager;
import com.yun.reader.product.reader.manager.module.DownloadFileResponse;

import java.io.File;

import javax.inject.Inject;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/8/28 .
 * 邮箱 liulei@getui.com.
 */


public class ReaderDetailPresenter extends BasePresenter<ReaderActivity> {
    @Inject
    ReadeDetailManager manager;

    @Inject
    public ReaderDetailPresenter(ViewImpl iView) {
        super(iView);
    }

    public void downloadChapterList(final String bookId) {
        manager.downloadChaptersList(bookId, new CommonObserver<DownloadFileResponse>() {

            @Override
            public void doSuccess(ResultResponse<DownloadFileResponse> result) {
                if (result.getCode() == 0) {
                    FileHelper.getInstance().deleteFileByBookId(bookId);
                    if (ZipUtil.unzip(result.getData().getFile(), FileHelper.getInstance().getOnlineRootPath(bookId))) {
                        result.getData().getFile().delete();
                    }
                }
            }

            @Override
            public void doFail(String msg) {
                Toast.makeText(getBaseActivity(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void downloadChapterDetail(final String bookId, int startPage) {

        String[] chapterDirectoryList = new String[7];
        if (startPage == 1) {
            chapterDirectoryList = new String[]{"1", "2", "3", "4", "5", "6", "7"};
        }
        manager.downloadChapters(bookId, chapterDirectoryList, new CommonObserver<DownloadFileResponse>() {

            @Override
            public void doSuccess(ResultResponse<DownloadFileResponse> result) {
                if (result.getData() != null) {
                    String filePath = FileStrings.ONLINE + UserHelper.getUserInfo().getUserId() + bookId + File.separator + System.currentTimeMillis();
                    File file=new File(filePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }

                }
            }

            @Override
            public void doFail(String msg) {

            }
        });
    }
}
