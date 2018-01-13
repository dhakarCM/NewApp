package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

public class Slider {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("cover_image")
    private String coverImage;
    @SerializedName("gallery_cover_photos")
    private String galleryCoverPhotos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getGalleryCoverPhotos() {
        return galleryCoverPhotos;
    }

    public void setGalleryCoverPhotos(String galleryCoverPhotos) {
        this.galleryCoverPhotos = galleryCoverPhotos;
    }
}
