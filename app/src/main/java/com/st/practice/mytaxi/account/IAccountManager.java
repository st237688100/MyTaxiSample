package com.st.practice.mytaxi.account;

import android.os.Handler;

/**
 *
 */
public interface IAccountManager {

    int LOGIN_PHONE_SUC = 1;
    int LOGIN_SMS_SUC = 2;
    int LOGIN_PHONE_FAIL = -1;
    int LOGIN_SMS_FAIL = -2;
    int LOGIN_GET_CODE_SUC = 3;
    int LOGIN_GET_CODE_FAIL = -3;

    /**
     * 账号密码登录
     */
    void loginByPhonePwd(String phone, String password);

    /**
     * 短信登录
     */
    void loginBySMS(String phone, String code);

    void getSMSCode(String phone);

    /**
     * 是否登录
     */
    boolean isLogin();

    void setHandler(Handler handler);

}
