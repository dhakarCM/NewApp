package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 12/8/2017.
 */
public class NewHomeResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("error")
    private String error;
    @SerializedName("response")
    private Response response;

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

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
