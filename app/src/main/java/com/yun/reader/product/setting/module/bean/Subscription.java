package com.yun.reader.product.setting.module.bean;

import java.io.Serializable;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/6/12 .
 * 邮箱 liulei@getui.com.
 */


public class Subscription implements Serializable {
    /**
     * id : 1
     * name : 精选
     * url : https://app2.zhulang.com/Index/index_selective
     * isEditable : 0
     * subFlag : HOT
     * selected : 1
     * sortIndex : 999
     */

    private String id;
    private String name;
    private String url;
    private int isEditable;
    private String subFlag;
    private int selected;
    private int sortIndex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(int isEditable) {
        this.isEditable = isEditable;
    }

    public String getSubFlag() {
        return subFlag;
    }

    public void setSubFlag(String subFlag) {
        this.subFlag = subFlag;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}
