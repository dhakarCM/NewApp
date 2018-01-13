package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

public class Galleryphotos {
    @SerializedName("id")
    private int id;
    @SerializedName("gallery_id")
    private int galleryId;
    @SerializedName("image")
    private String image;
    @SerializedName("description")
    private String description;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("image_fullpath")
    private String imageFullpath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getImageFullpath() {
        return imageFullpath;
    }

    public void setImageFullpath(String imageFullpath) {
        this.imageFullpath = imageFullpath;
    }
}
