package com.example.newsfeed.UserInfo;

import android.net.Uri;

public class ModelUser {

    String name;
    String email;
    String uid;
    Uri image;

    public ModelUser(){

    }

    public ModelUser(String name, String email, String uid, Uri image) {
        this.name = name;
        this.email = email;
        this.uid = uid;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
