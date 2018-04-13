package com.example.shree.myapplication5;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by comp on 11-03-2018.
 */

public class Fetch_scheme {
    @SerializedName("cid")
    @Expose
    int catid;

    @SerializedName("category_name")
    @Expose
    String title;

    @SerializedName("forwomen")
    @Expose
    int forwomen;

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public int getForwomen() {
        return forwomen;
    }

    public void setForwomen(int forwomen) {
        this.forwomen = forwomen;
    }

    public int getIsnew() {
        return isnew;
    }

    public void setIsnew(int isnew) {
        this.isnew = isnew;
    }

    @SerializedName("isnew")
    @Expose
    int isnew;


    @SerializedName("sid")
    @Expose
    int sid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
