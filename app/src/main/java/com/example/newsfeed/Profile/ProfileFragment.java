package com.example.newsfeed.Profile;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.newsfeed.MainActivity;
import com.example.newsfeed.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    FirebaseAuth firebaseAuth;

    Button logOut;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        logOut = view.findViewById(R.id.logoutBtn);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                checkUserStatus();
            }
        });

        return view;
    }

    private void checkUserStatus(){

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            // user is already logged in , stay here

        }
        else {
            // go to main activity
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
        }

    }

}
