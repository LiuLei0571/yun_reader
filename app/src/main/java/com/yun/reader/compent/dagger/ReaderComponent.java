package com.yun.reader.compent.dagger;

import com.yun.reader.compent.sys.YunControlHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 用途：将AppComponent中的方法暴露，以便于其他依赖于AppComponent的component调用。
 * 需要将SubComponent追加到被依赖的Component中.
 *
 * @author ：Created by liulei.
 * @date 2018/4/18 .
 * 邮箱:liulei@getui.com.
 */
@Singleton
@Component(modules = {ReaderModule.class, ManagerModule.class})
public interface ReaderComponent {
    ActivityComponent plus(ActivityModule activityModule);

    FragmentComponent plus(FragmentModule fragmentModule);

    ServiceComponent plus(ServiceModule serviceModule);

    DialogComponent plus(DialogModule dialogModule);

    void plus(YunControlHelper yunControlHelper);

    void plus(ReaderControlHelper readerControlHelper);
}
