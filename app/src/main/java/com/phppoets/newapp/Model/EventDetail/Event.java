package com.phppoets.newapp.Model.EventDetail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("location")
    private String location;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("description")
    private String description;
    @SerializedName("status")
    private String status;
    @SerializedName("cover_image")
    private String coverImage;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("created_by")
    private int createdBy;
    @SerializedName("edited_on")
    private String editedOn;
    @SerializedName("edited_by")
    private int editedBy;
    @SerializedName("published_on")
    private String publishedOn;
    @SerializedName("published_by")
    private int publishedBy;
    @SerializedName("event_category_id")
    private int eventCategoryId;
    @SerializedName("event_attendees")
    private List<EventAttendees> eventAttendees;
    @SerializedName("event_guests")
    private List<EventGuets> eventGuests;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getEventCategoryId() {
        return eventCategoryId;
    }

    public void setEventCategoryId(int eventCategoryId) {
        this.eventCategoryId = eventCategoryId;
    }

    public List<EventAttendees> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(List<EventAttendees> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }

    public List<EventGuets> getEventGuests() {
        return eventGuests;
    }

    public void setEventGuests(List<EventGuets> eventGuests) {
        this.eventGuests = eventGuests;
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
