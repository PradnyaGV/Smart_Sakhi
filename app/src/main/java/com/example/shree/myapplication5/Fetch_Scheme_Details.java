package com.example.shree.myapplication5;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by comp on 21-03-2018.
 */

public class Fetch_Scheme_Details {
    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("DOLaunch")
    @Expose
    String DOLaunch;

    @SerializedName("benefits")
    @Expose
    String benefits;

    @SerializedName("eligibility")
    @Expose
    String eligibility;

    @SerializedName("howtoapply")
    @Expose
    String howtoapply;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDOLaunch() {
        return DOLaunch;
    }

    public void setDOLaunch(String DOLaunch) {
        this.DOLaunch = DOLaunch;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getHowtoapply() {
        return howtoapply;
    }

    public void setHowtoapply(String howtoapply) {
        this.howtoapply = howtoapply;
    }
}
