package com.phppoets.newapp.Model.event;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by user on 11/29/2017.
 */
public class EventResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("error")
    private String error;
    @SerializedName("eventlist")
    private List<Eventlist> eventlist;

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

    public List<Eventlist> getEventlist() {
        return eventlist;
    }

    public void setEventlist(List<Eventlist> eventlist) {
        this.eventlist = eventlist;
    }
}
