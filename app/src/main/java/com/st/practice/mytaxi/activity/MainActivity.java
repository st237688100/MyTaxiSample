package com.st.practice.mytaxi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.st.practice.mytaxi.LoginDialog;
import com.st.practice.mytaxi.R;

public class MainActivity extends AppCompatActivity {

    LoginDialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginDialog loginDialog = new LoginDialog(this);
        loginDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
