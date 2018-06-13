package com.yun.reader.product.splash.presenter;

import android.widget.Toast;

import com.yun.reader.common.config.CacheKeys;
import com.yun.reader.common.config.SpKeys;
import com.yun.reader.common.helper.SpHelper;
import com.yun.reader.common.helper.TokenHelper;
import com.yun.reader.common.http.response.ResultResponse;
import com.yun.reader.compent.base.BasePresenter;
import com.yun.reader.compent.base.impl.ViewImpl;
import com.yun.reader.compent.http.CommonObserver;
import com.yun.reader.product.login.module.LoginAutoManager;
import com.yun.reader.product.login.module.bean.LoginAuto;
import com.yun.reader.product.setting.module.SubscriptionManager;
import com.yun.reader.product.setting.module.bean.Subscription;
import com.yun.reader.product.splash.view.SelectGenderActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */

public class SelectGenderPresenter extends BasePresenter<SelectGenderActivity> {
    @Inject
    LoginAutoManager loginAutoManager;
    @Inject
    SubscriptionManager subscriptionManager;

    @Inject
    public SelectGenderPresenter(ViewImpl iView) {
        super(iView);
    }

    public void loginAuto() {
        loginAutoManager.loginAuto(new CommonObserver<LoginAuto>() {
            @Override
            public void doSuccess(ResultResponse<LoginAuto> result) {
                if (result.getData() != null) {
                    LoginAuto userInfo = result.getData();
                    TokenHelper.setUserToken(userInfo.getToken());
                    SpHelper.putBean(SpKeys.LOGIN_AUTO, result.getData());
                }
            }
            @Override
            public void doFail(String msg) {
                Toast.makeText(getBaseActivity(), msg, Toast.LENGTH_LONG).show();
            }
        });
        subscriptionManager.userConf(new CommonObserver<List<Subscription>>() {

            @Override
            public void doSuccess(ResultResponse<List<Subscription>> result) {
                if (result.getCode() == 0) {
                    SpHelper.putBean(CacheKeys.YUN_SUBSCRIPTION, result.getData());
                }
            }

            @Override
            public void doFail(String msg) {

            }
        });
    }
}
