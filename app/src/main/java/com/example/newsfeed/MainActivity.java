package com.example.newsfeed;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;
import com.example.newsfeed.UserInfo.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSION_REQUEST_CODE = 1234;
    private static int Splash_time_Out = 2500;

    FirebaseAuth firebaseAuth;
    private String[] appPermissions;

    LazyLoader lazyLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        lazyLoader = findViewById(R.id.loaderDots);
        LazyLoader loader = new LazyLoader(this, 30, 20, ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected));
        loader.setAnimDuration(500);
        loader.setFirstDelayDuration(100);
        loader.setSecondDelayDuration(200);
        loader.setInterpolator(new LinearInterpolator());

        lazyLoader.addView(loader);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getAppPermissions();
                firebaseAuth = FirebaseAuth.getInstance();
                checkUserStatus();
            }
        },Splash_time_Out);



    }

    private void checkUserStatus(){

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            Intent intent = new Intent(MainActivity.this, Newsfeed.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void getAppPermissions(){

        appPermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA};

        ActivityCompat.requestPermissions(this, appPermissions, PERMISSION_REQUEST_CODE);

    }

}
