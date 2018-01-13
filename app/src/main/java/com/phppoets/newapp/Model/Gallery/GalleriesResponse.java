package com.phppoets.newapp.Model.Gallery;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by user on 11/29/2017.
 */
public class GalleriesResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("error")
    private String error;
    @SerializedName("response")
    private List<Response> response;

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

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public List<Response> getGallery() {
        return response;
    }
}
