package com.st.practice.mytaxi.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.st.practice.mytaxi.R;
import com.st.practice.mytaxi.ui.dialog.LoginDialog;

public class MainActivity extends AppCompatActivity {

    LoginDialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginDialog = new LoginDialog(this);
        loginDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loginDialog.isShowing()) {
            loginDialog.dismiss();
        }
    }
}
