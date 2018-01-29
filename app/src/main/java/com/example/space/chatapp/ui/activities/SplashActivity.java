package com.example.space.chatapp.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.space.chatapp.R;
import com.example.space.chatapp.data.StaticConfig;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_MS = 1000;
    private Handler mHandler;
    private Runnable mRunnable;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                // check if user in already logged in or not
                user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    StaticConfig.UID = user.getUid();
                    startActivity(new Intent(SplashActivity.this, TabsActivity.class));
//                    UserListingActivity.startActivity(SplashActivity.this);
                } else {
//                    LoginActivity.startIntent(SplashActivity.this);
                    startActivity(new Intent(SplashActivity.this, LoginActivity2.class));
                    SplashActivity.this.finish();
                }
                finish();
            }
        };
        mHandler.postDelayed(mRunnable, SPLASH_TIME_MS);
    }
}
