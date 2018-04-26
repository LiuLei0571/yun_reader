package com.yun.reader.compent.cookie;


import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

public class PersistentCookieJar implements ClearableCookieJar {
    private CookieCache cookieCache;
    private CookiePersistor cookiePersistor;

    public PersistentCookieJar(CookieCache cookieCache, CookiePersistor cookiePersistor) {
        this.cookieCache = cookieCache;
        this.cookiePersistor = cookiePersistor;
        this.cookieCache.addAll(cookiePersistor.loadAll());
    }

    @Override
    public synchronized void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        this.cookieCache.addAll(list);
        this.cookiePersistor.saveAll(checkCookieList(list));
    }

    /* renamed from: a */
    private static List<Cookie> checkCookieList(List<Cookie> list) {
        ArrayList arrayList = new ArrayList();
        for (Cookie cookie : list) {
            if (cookie.persistent()) {
                arrayList.add(cookie);
            }
        }
        return arrayList;
    }

    @Override
    public synchronized List<Cookie> loadForRequest(HttpUrl httpUrl) {
        List<Cookie> arrayList;
        Collection arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator it = this.cookieCache.iterator();
        while (it.hasNext()) {
            Cookie cookie = (Cookie) it.next();
            if (isCookieTimeout(cookie)) {
                arrayList2.add(cookie);
                it.remove();
            } else if (cookie.matches(httpUrl)) {
                arrayList.add(cookie);
            }
        }
        this.cookiePersistor.saveAll(arrayList2);
        return arrayList;
    }

    private static boolean isCookieTimeout(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }
}
