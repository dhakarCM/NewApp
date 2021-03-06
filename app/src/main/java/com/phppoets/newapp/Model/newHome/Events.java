package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

public class Events {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("published_on")
    private String publishedOn;
    @SerializedName("description")
    private String description;
    @SerializedName("cover_image")
    private String coverImage;
    @SerializedName("location")
    private String location;
    @SerializedName("event_day")
    private String eventDay;
    @SerializedName("event_month")
    private String eventMonth;
    @SerializedName("event_year")
    private String eventYear;
    @SerializedName("event_date")
    private String eventDate;
    @SerializedName("cover_image_fullpath")
    private String coverImageFullpath;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventDay() {
        return eventDay;
    }

    public void setEventDay(String eventDay) {
        this.eventDay = eventDay;
    }

    public String getEventMonth() {
        return eventMonth;
    }

    public void setEventMonth(String eventMonth) {
        this.eventMonth = eventMonth;
    }

    public String getEventYear() {
        return eventYear;
    }

    public void setEventYear(String eventYear) {
        this.eventYear = eventYear;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getCoverImageFullpath() {
        return coverImageFullpath;
    }

    public void setCoverImageFullpath(String coverImageFullpath) {
        this.coverImageFullpath = coverImageFullpath;
    }
}
