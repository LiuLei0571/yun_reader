package com.yun.reader.product;

import com.yun.reader.common.helper.TokenHelper;
import com.yun.reader.compent.base.BasePresenter;
import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.conver.ResultResponse;
import com.yun.reader.compent.http.CommonObserver;
import com.yun.reader.product.user.LoginResponse;

import javax.inject.Inject;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */


public class MainPresenter extends BasePresenter<MainActivity> {
    String str;
    @Inject
    MainManager mainManager;

    @Inject
    public MainPresenter(ViewImpl iView) {
        super(iView);
    }

    public void getData() {
        mainManager.loginAuto(new CommonObserver<LoginResponse>() {
            @Override
            public void doSuccess(ResultResponse<LoginResponse> result) {
                if (result.getData() != null) {
                    LoginResponse loginResponse = result.getData();
                    TokenHelper.setUserToken(loginResponse.getToken());
                    getView().showLoginName(loginResponse.getUserName());
                }
            }

            @Override
            public void doFail(String msg) {

            }
        });
    }
}
