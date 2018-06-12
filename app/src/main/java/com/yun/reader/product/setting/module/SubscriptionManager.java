package com.yun.reader.product.setting.module;

import com.yun.reader.common.config.CacheKeys;
import com.yun.reader.common.helper.SpHelper;
import com.yun.reader.common.util.DeviceUtil;
import com.yun.reader.compent.base.BaseManager;
import com.yun.reader.compent.http.CommonObserver;
import com.yun.reader.product.setting.module.bean.Subscription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/6/12 .
 * 邮箱 liulei@getui.com.
 */


public class SubscriptionManager extends BaseManager {
    public void userConf(CommonObserver commonObserver) {
        Map<String, Object> params = new HashMap<>();
        params.put("deviceSDK", DeviceUtil.getDeviceSdk());
        handlerObserver(retrofitApis.userConf(params), commonObserver);
    }

    public void saveConf(List<Subscription> subscriptionList) {
        SpHelper.putBean(CacheKeys.YUN_SUBSCRIPTION, subscriptionList);
    }

    public List<Subscription> getConf() {
        return SpHelper.getBean(CacheKeys.YUN_SUBSCRIPTION, Subscription.class);
    }
}
