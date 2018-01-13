package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

public class Homemenus {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("link")
    private String link;
    @SerializedName("image")
    private String image;
    @SerializedName("image_fullpath")
    private String imageFullpath;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageFullpath() {
        return imageFullpath;
    }

    public void setImageFullpath(String imageFullpath) {
        this.imageFullpath = imageFullpath;
    }
}
