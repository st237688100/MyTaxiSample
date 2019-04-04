package com.st.practice.mytaxi.presenter;

import android.os.Handler;

import com.st.practice.mytaxi.account.User;
import com.st.practice.mytaxi.iview.IView;

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
