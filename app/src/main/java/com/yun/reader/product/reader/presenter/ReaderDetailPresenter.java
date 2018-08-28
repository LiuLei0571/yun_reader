package com.yun.reader.product.reader.presenter;

import android.widget.Toast;

import com.yun.reader.common.file.ZipUtil;
import com.yun.reader.common.helper.FileHelper;
import com.yun.reader.common.http.response.ResultResponse;
import com.yun.reader.compent.base.BasePresenter;
import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.http.CommonObserver;
import com.yun.reader.product.reader.ReaderActivity;
import com.yun.reader.product.reader.manager.ReadeDetailManager;
import com.yun.reader.product.reader.manager.module.DownloadFileResponse;

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

    public void downloadChapterZip(final String bookId) {
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
}
