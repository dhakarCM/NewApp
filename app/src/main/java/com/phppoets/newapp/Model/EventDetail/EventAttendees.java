package com.phppoets.newapp.Model.EventDetail;

import com.google.gson.annotations.SerializedName;

public class EventAttendees {
    @SerializedName("id")
    private int id;
    @SerializedName("event_id")
    private int eventId;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("answer")
    private String answer;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("created_by")
    private int createdBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
}
