package com.yun.reader.product;

import com.yun.reader.common.helper.SpHelper;
import com.yun.reader.common.helper.TokenHelper;
import com.yun.reader.compent.base.BasePresenter;
import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.conver.ResultResponse;
import com.yun.reader.compent.http.CommonObserver;
import com.yun.reader.product.user.UserInfo;

import javax.inject.Inject;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public class MainPresenter extends BasePresenter<MainActivity> {
    @Inject
    MainManager mainManager;

    @Inject
    public MainPresenter(ViewImpl iView) {
        super(iView);
    }

    public void getData() {
        mainManager.loginAuto(new CommonObserver<UserInfo>() {
            @Override
            public void doSuccess(ResultResponse<UserInfo> result) {
                if (result.getData() != null) {
                    UserInfo userInfo = result.getData();
                    TokenHelper.setUserToken(userInfo.getToken());
                    SpHelper.putBean("user_auto", userInfo);
                    getView().showLoginName(userInfo.getUserName());
                }
            }
            @Override
            public void doFail(String msg) {

            }
        });
    }
}
