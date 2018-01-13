package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

public class Blogs {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("cover_image")
    private String coverImage;
    @SerializedName("published_on")
    private String publishedOn;
    @SerializedName("published_by")
    private int publishedBy;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("created_by")
    private int createdBy;
    @SerializedName("status")
    private String status;
    @SerializedName("edited_on")
    private String editedOn;
    @SerializedName("edited_by")
    private int editedBy;
    @SerializedName("user")
    private User user;
    @SerializedName("cover_image_fullpath")
    private String coverImageFullpath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public int getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(int publishedBy) {
        this.publishedBy = publishedBy;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(String editedOn) {
        this.editedOn = editedOn;
    }

    public int getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(int editedBy) {
        this.editedBy = editedBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCoverImageFullpath() {
        return coverImageFullpath;
    }

    public void setCoverImageFullpath(String coverImageFullpath) {
        this.coverImageFullpath = coverImageFullpath;
    }
}
