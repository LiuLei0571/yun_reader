package com.yun.reader.product.user;

import java.io.Serializable;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/26 .
 * 邮箱:liulei@getui.com.
 */


public class LoginResponse implements Serializable {

    /**
     * userId : 51353994
     * userName : APPREG_51353994
     * nickName : APP_51353994
     * balance : 0
     * subBalance : 0
     * avatarUrl : https://i.zhulang.com/avatar/200.gif
     * mobileNum :
     * gender : 2
     * deviceOnly : 1
     * token : 676841b16c8889e4e2761e2842b23783
     * nickNameEditable : 0
     * expLv : Lv0
     * flowerNum : 0
     */

    private String userId;
    private String userName;
    private String nickName;
    private String balance;
    private String subBalance;
    private String avatarUrl;
    private String mobileNum;
    private int gender;
    private int deviceOnly;
    private String token;
    private int nickNameEditable;
    private String expLv;
    private int flowerNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getSubBalance() {
        return subBalance;
    }

    public void setSubBalance(String subBalance) {
        this.subBalance = subBalance;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDeviceOnly() {
        return deviceOnly;
    }

    public void setDeviceOnly(int deviceOnly) {
        this.deviceOnly = deviceOnly;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getNickNameEditable() {
        return nickNameEditable;
    }

    public void setNickNameEditable(int nickNameEditable) {
        this.nickNameEditable = nickNameEditable;
    }

    public String getExpLv() {
        return expLv;
    }

    public void setExpLv(String expLv) {
        this.expLv = expLv;
    }

    public int getFlowerNum() {
        return flowerNum;
    }

    public void setFlowerNum(int flowerNum) {
        this.flowerNum = flowerNum;
    }
}
