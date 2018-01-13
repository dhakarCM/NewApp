package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

public class Advertisements {
    @SerializedName("id")
    private int id;
    @SerializedName("photo")
    private String photo;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("created_by")
    private int createdBy;
    @SerializedName("image_fullpath")
    private String imageFullpath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getImageFullpath() {
        return imageFullpath;
    }

    public void setImageFullpath(String imageFullpath) {
        this.imageFullpath = imageFullpath;
    }
}
