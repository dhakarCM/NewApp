package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

public class Affilationregistrations {
    @SerializedName("id")
    private int id;
    @SerializedName("logo")
    private String logo;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("created_by")
    private int createdBy;
    @SerializedName("fullpath_image")
    private String fullpathImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getFullpathImage() {
        return fullpathImage;
    }

    public void setFullpathImage(String fullpathImage) {
        this.fullpathImage = fullpathImage;
    }
}
