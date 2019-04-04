package com.st.practice.mytaxi.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.st.practice.mytaxi.R;
import com.st.practice.mytaxi.account.AccountManager;
import com.st.practice.mytaxi.account.IAccountManager;
import com.st.practice.mytaxi.iview.ILoginDialogView;
import com.st.practice.mytaxi.presenter.ILoginDialogPresenter;
import com.st.practice.mytaxi.presenter.LoginDialogPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginDialog extends Dialog implements ILoginDialogView {

    ILoginDialogPresenter iLoginDialogPresenter;

    @BindView(R.id.et_phone)
    EditText    etPhone;
    @BindView(R.id.et_code)
    EditText    etCode;
    @BindView(R.id.tv_send_code)
    TextView    tvSendCode;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    @OnClick(R.id.tv_send_code)
    void onTvSendCodeClick() {
        String phone = etPhone.getText().toString();
        tvSendCode.setEnabled(false);
        iLoginDialogPresenter.requestSmsCode(phone);
    }

    @OnClick(R.id.tv_submit)
    void onTvSubmitClick() {
        String phone = etPhone.getText().toString();
        String code = etCode.getText().toString();
        iLoginDialogPresenter.requestSmsLogin(phone, code);
    }


    public LoginDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_login);
        ButterKnife.bind(this);
        IAccountManager accountManager = new AccountManager();
        LoginDialogPresenter.MyHandler handler = new LoginDialogPresenter.MyHandler(this);
        this.iLoginDialogPresenter = new LoginDialogPresenter(this, accountManager, handler);
        accountManager.setHandler(handler);
    }

    @Override
    public void handleLoginSuccess() {
        this.dismiss();
        Toast.makeText(getContext(), "登录成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showCode(String code) {
        Toast.makeText(getContext(), "验证码：1234", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showTimerTick(long millisUntilFinished) {
        tvSendCode.setText("剩余" + millisUntilFinished / 1000 + "秒");
    }

    @Override
    public void showTimerFinish() {
        tvSendCode.setEnabled(true);
        tvSendCode.setText("获取验证码");
    }

    @Override
    public void showRequestFail(Object obj) {
        if (obj instanceof String) {
            Toast.makeText(getContext(), ((String) obj), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showLoading(boolean isShow) {
        if (isShow) {
            pbLoading.setVisibility(View.VISIBLE);
        } else {
            pbLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "登录失败", Toast.LENGTH_LONG).show();
    }
}
