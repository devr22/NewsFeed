package com.example.newsfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.example.newsfeed.UserInfo.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSION_REQUEST_CODE = 1234;

    FirebaseAuth firebaseAuth;
    private String[] appPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAppPermissions();
        firebaseAuth = FirebaseAuth.getInstance();
        checkUserStatus();

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
