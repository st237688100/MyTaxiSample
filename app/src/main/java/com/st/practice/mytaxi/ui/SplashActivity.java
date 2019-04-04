package com.st.practice.mytaxi.ui;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.st.practice.mytaxi.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startDrableAnimate();
        }
        jumpNextPage();
    }

    private void jumpNextPage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }

    private void startDrableAnimate() {
        ImageView ivSpalsh = findViewById(R.id.iv_splash);
        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim_splash);
        ivSpalsh.setBackground(animatedVectorDrawable);
        animatedVectorDrawable.start();
    }
}
