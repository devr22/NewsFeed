package com.example.newsfeed.Search;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsfeed.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    /*private void searchPosts(final String searchQuery){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("Posts");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postList.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    ModelPost modelPost = ds.getValue(ModelPost.class);

                    if (modelPost.getpTitle().toLowerCase().contains(searchQuery.toLowerCase()) ||
                            modelPost.getpDescription().toLowerCase().contains(searchQuery.toLowerCase())){
                        postList.add(modelPost);
                    }
                    adapterPosts = new AdapterPosts(getActivity(), postList);
                    recyclerView.setAdapter(adapterPosts);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "loadPosts: cancelled" + databaseError.getMessage());
                Toast.makeText(getActivity(), "" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/

}
