package com.st.practice.mytaxi;


import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/**
 * @Author: shiteng
 * @Date: 2019/4/2 22:56
 */
public class AccountManager implements IAccountManager {

    Handler handler;

    User user;

    @Override
    public void loginByPhonePwd(String phone, final String password) {
        new Thread() {

            @Override
            public void run() {
                SystemClock.sleep(2000);
                if ("1234567".equals(password)) {
                    user = new User("小明", "1234567");
                    handler.sendEmptyMessage(LOGIN_PHONE_SUC);
                } else {
                    handler.sendEmptyMessage(LOGIN_PHONE_FAIL);
                }
            }
        }.start();
    }

    @Override
    public void loginBySMS(String phone, final String code) {
        new Thread() {

            @Override
            public void run() {
                SystemClock.sleep(1000);
                if ("1234".equals(code)) {
                    user = new User("小明", "1234567");
                    handler.sendEmptyMessage(LOGIN_SMS_SUC);
                } else {
                    Message message = Message.obtain();
                    message.what = LOGIN_SMS_FAIL;
                    message.obj = "网络错误，请重试";
                    handler.sendMessage(message);
                }
            }
        }.start();
    }

    @Override
    public void getSMSCode(final String phone) {
        new Thread() {

            @Override
            public void run() {
                SystemClock.sleep(1000);
                if (phone.length() == 5) {
                    user = new User("小明", "1234567");
                    Message message = Message.obtain();
                    message.what = LOGIN_GET_CODE_SUC;
                    message.obj = "1234";
                    handler.sendMessage(message);
                } else {
                    Message message = Message.obtain();
                    message.what = LOGIN_GET_CODE_FAIL;
                    message.obj = "手机号码不正确";
                    handler.sendMessage(message);
                }
            }
        }.start();

    }

    @Override
    public boolean isLogin() {
        return user == null ? false : true;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
