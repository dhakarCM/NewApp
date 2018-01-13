package com.phppoets.newapp.Model.Gallery;


import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("event_id")
    private int eventId;
    @SerializedName("blog_id")
    private int blogId;
    @SerializedName("cover_image")
    private String coverImage;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("created_by")
    private int createdBy;
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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
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

    public String getGalleryCoverPhotos() {
        return galleryCoverPhotos;
    }

    public void setGalleryCoverPhotos(String galleryCoverPhotos) {
        this.galleryCoverPhotos = galleryCoverPhotos;
    }
}
