package com.st.practice.mytaxi.presenter;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;

import com.st.practice.mytaxi.account.IAccountManager;
import com.st.practice.mytaxi.account.User;
import com.st.practice.mytaxi.iview.ILoginDialogView;

import java.lang.ref.WeakReference;


/**
 * @Author: shiteng
 * @Date: 2019/4/2 22:48
 */
public class LoginDialogPresenter implements ILoginDialogPresenter<ILoginDialogView> {

    private IAccountManager iAccountManager;

    private ILoginDialogView dialogView;

    private MyHandler mHandler;

    @Override
    public void attach(ILoginDialogView iview) {
        //this.dialogViewRef = new WeakReference<>(iview);
    }

    @Override
    public void detach() {
//        if (dialogViewRef != null) {
//            dialogViewRef.clear();
//            dialogViewRef = null;
//        }
    }


    public static class MyHandler extends Handler {

        private WeakReference<ILoginDialogView> dialogViewRef;

        public MyHandler(ILoginDialogView iLoginDialogView){
            this.dialogViewRef = new WeakReference<>(iLoginDialogView);
        }


        @Override
        public void handleMessage(Message msg) {
            if (dialogViewRef.get() == null) return;
            ILoginDialogView dialogView = dialogViewRef.get();
            switch (msg.what) {
                case IAccountManager.LOGIN_PHONE_SUC:
                    dialogView.showLoading(false);
                    dialogView.handleLoginSuccess();
                    break;
                case IAccountManager.LOGIN_SMS_SUC:
                    dialogView.showLoading(false);
                    dialogView.handleLoginSuccess();
                    break;
                case IAccountManager.LOGIN_GET_CODE_SUC:
                    dialogView.showLoading(false);
                    dialogView.showCode(((String) msg.obj));
                    break;
                case IAccountManager.LOGIN_PHONE_FAIL:
                    dialogView.showLoading(false);
                    dialogView.showRequestFail(msg.obj);
                    break;
                case IAccountManager.LOGIN_SMS_FAIL:
                    dialogView.showLoading(false);
                    dialogView.showRequestFail(msg.obj);
                    break;
                case IAccountManager.LOGIN_GET_CODE_FAIL:
                    dialogView.showLoading(false);
                    dialogView.showRequestFail(msg.obj);
                    break;
            }
        }
    }

    CountDownTimer timer = new CountDownTimer(10 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            dialogView.showTimerTick(millisUntilFinished);
        }

        @Override
        public void onFinish() {
            dialogView.showTimerFinish();
        }
    };

    public LoginDialogPresenter(ILoginDialogView iView, IAccountManager iAccountManager,MyHandler handler) {
        this.mHandler = handler;
        this.iAccountManager = iAccountManager;
        attach(iView);
    }

    @Override
    public void requestPhoneLogin(String phone, String password) {
        dialogView.showLoading(true);
        iAccountManager.loginByPhonePwd(phone, password);
    }

    @Override
    public void requestSmsLogin(String phone, String code) {
        dialogView.showLoading(true);
        iAccountManager.loginBySMS(phone, code);
    }

    @Override
    public void requestSmsCode(String phone) {
        timer.start();
        dialogView.showLoading(true);
        iAccountManager.getSMSCode(phone);
    }

    @Override
    public void showLoginSuc(int type, User user) {
        dialogView.handleLoginSuccess();
    }

    @Override
    public Handler getHandler() {
        return mHandler;
    }

}
