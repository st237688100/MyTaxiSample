package com.st.practice.mytaxi.iview;

/**
 * @Author: shiteng
 * @Date: 2019/4/2 22:46
 */
public interface ILoginDialogView extends IView {

    void handleLoginSuccess();

    void showCode(String code);

    void showTimerTick(long millisUntilFinished);

    void showTimerFinish();

    void showRequestFail(Object obj);
}
