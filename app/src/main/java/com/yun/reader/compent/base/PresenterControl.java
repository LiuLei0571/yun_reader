package com.yun.reader.compent.base;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/20 .
 * 邮箱:liulei@getui.com.
 */


public class PresenterControl {
    private HashSet<BasePresenter> presenters;

    public void bind(Bundle savedInstanceState, Bundle extras) {
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                basePresenter.doCreate(savedInstanceState, extras);
            }
        }
    }

    protected void savePresenter(BasePresenter basePresenter) {
        if (presenters == null) {
            presenters = new HashSet<>();
        }
        if (basePresenter != null) {
            presenters.add(basePresenter);
        }
    }

    protected void onResume() {
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                basePresenter.onResume();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                basePresenter.onActivityResult(requestCode,resultCode,data);
            }
        }
    }

    protected void onDestroy() {
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                basePresenter.onDestroy();
            }
        }
    }
}
