package com.example.newsfeed.Adapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.example.newsfeed.Model.ModelPost;
import com.example.newsfeed.R;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.MyHolder> {

    private static final String TAG = "AdapterPosts";

    Context context;
    List<ModelPost> postList;

    public AdapterPosts(Context context, List<ModelPost> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_posts, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        String uid = postList.get(position).getUid();
        String uEmail = postList.get(position).getuEmail();
        String uName = postList.get(position).getuName();
        String udp = postList.get(position).getUdp();
        String pId = postList.get(position).getpId();
        String pTitle = postList.get(position).getpTitle();
        String pDescription = postList.get(position).getpDescription();
        String pImage = postList.get(position).getpImage();
        String pTimeStamp = postList.get(position).getpTime();

        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(pTimeStamp));
        String pTime = DateFormat.format("dd/MM/yyyy hh:mm: aa", calendar).toString();

        holder.nameTV.setText(uName);
        Log.d(TAG, "onBindViewHolder: " + uName);
        holder.timeTV.setText(pTime);
        holder.titleTV.setText(pTitle);
        holder.descriptionTV.setText(pDescription);

        // set user dp
        try{
            Picasso.get().load(udp).placeholder(R.drawable.ic_default_profile_photo).into(holder.dpImage);
        }
        catch (Exception e){
            Log.d(TAG, "onBindViewHolder: User DP " + e.getMessage());
        }
        //set post Image
        if (pImage.equals("noImage")){
             holder.postIV.setVisibility(View.GONE);
        }
        else {
            try{
                Picasso.get().load(pImage).into(holder.postIV);
            }
            catch (Exception e){
                Log.d(TAG, "onBindViewHolder: Post Image " + e.getMessage());
            }
        }

        holder.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "More", Toast.LENGTH_SHORT).show();
            }
        });

        holder.likeButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });

        holder.commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageButton likeButton, commentButton, shareButton, moreButton;
        TextView nameTV, timeTV, titleTV, descriptionTV, likesTV;
        ImageView postIV;
        CircularImageView dpImage;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            //init views
            likeButton = itemView.findViewById(R.id.row_likeButton);
            commentButton = itemView.findViewById(R.id.row_commentButton);
            shareButton = itemView.findViewById(R.id.row_shareButton);
            moreButton = itemView.findViewById(R.id.row_moreButton);
            nameTV = itemView.findViewById(R.id.row_UserName);
            timeTV = itemView.findViewById(R.id.row_time);
            titleTV = itemView.findViewById(R.id.row_title);
            descriptionTV = itemView.findViewById(R.id.row_description);
            likesTV = itemView.findViewById(R.id.row_likes);
            postIV = itemView.findViewById(R.id.row_postImage);
            dpImage = itemView.findViewById(R.id.row_dp);
        }
    }

}
