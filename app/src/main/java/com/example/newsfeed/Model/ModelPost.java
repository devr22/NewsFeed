package com.example.newsfeed.Model;

public class ModelPost {

    String pId, ptitle, pdescription, pLikes, pImage, pTime, uid, uemail, uname, udp;

    public ModelPost() {
    }

    public ModelPost(String pId, String ptitle, String pdescription, String pLikes, String pImage, String pTime, String uid, String uemail, String uname, String udp) {
        this.pId = pId;
        this.ptitle = ptitle;
        this.pdescription = pdescription;
        this.pLikes = pLikes;
        this.pImage = pImage;
        this.pTime = pTime;
        this.uid = uid;
        this.uemail = uemail;
        this.uname = uname;
        this.udp = udp;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public String getpLikes() {
        return pLikes;
    }

    public void setpLikes(String pLikes) {
        this.pLikes = pLikes;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUdp() {
        return udp;
    }

    public void setUdp(String udp) {
        this.udp = udp;
    }
}
