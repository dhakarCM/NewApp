package com.phppoets.newapp.Model.EventDetail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by user on 12/1/2017.
 */
public class EventDetailResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("error")
    private String error;
    @SerializedName("event")
    private List<Event> event;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
}
