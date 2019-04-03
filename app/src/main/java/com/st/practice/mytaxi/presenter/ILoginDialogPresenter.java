package com.st.practice.mytaxi.presenter;

import android.os.Handler;

import com.st.practice.mytaxi.IView;
import com.st.practice.mytaxi.User;

/**
 * @Author: shiteng
 * @Date: 2019/4/2 22:50
 */
public interface ILoginDialogPresenter<T extends IView> extends IPresenter<T> {

    void requestPhoneLogin(String phone,String password);

    void requestSmsLogin(String phone,String code);

    void requestSmsCode(String phone);

    void showLoginSuc(int type, User user);

    Handler getHandler();

}
