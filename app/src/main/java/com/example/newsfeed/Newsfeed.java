package com.example.newsfeed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.newsfeed.Home.HomeFragment;
import com.example.newsfeed.Profile.ProfileFragment;
import com.example.newsfeed.Search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Newsfeed extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        callHomeFragment();

        firebaseAuth = FirebaseAuth.getInstance();
        bottomNavigationView = findViewById(R.id.newsFeed_bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()){

                        case R.id.nav_home:
                            //home fragment transaction
                            callHomeFragment();
                            return true;

                        case R.id.nav_profile:
                            //profile fragment transaction
                            callProfileFragment();
                            return true;

                        case R.id.nav_search:
                            // users fragment transaction
                            callSearchFragment();
                            return true;
                    }

                    return false;
                }
            };

    private void callHomeFragment(){

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction home_fragmentTransaction = getSupportFragmentManager().beginTransaction();
        home_fragmentTransaction.replace(R.id.newsFeed_container, homeFragment, "");
        home_fragmentTransaction.commit();
    }

    private void callProfileFragment(){

        ProfileFragment profileFragment = new ProfileFragment();
        FragmentTransaction profile_fragmentTransaction = getSupportFragmentManager().beginTransaction();
        profile_fragmentTransaction.replace(R.id.newsFeed_container, profileFragment, "");
        profile_fragmentTransaction.commit();
    }

    private void callSearchFragment(){

        SearchFragment searchFragment = new SearchFragment();
        FragmentTransaction search_fragmentTransaction = getSupportFragmentManager().beginTransaction();
        search_fragmentTransaction.replace(R.id.newsFeed_container, searchFragment, "");
        search_fragmentTransaction.commit();
    }

}
