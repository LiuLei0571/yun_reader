package com.yun.reader.compent.dagger;

import com.yun.reader.compent.base.BaseService;
import com.yun.reader.compent.dagger.annotion.ServiceScope;

import dagger.Subcomponent;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 */

@ServiceScope
@Subcomponent(modules = ServiceModule.class)
public interface ServiceComponent {
    void inject(BaseService baseService);
}
