package com.phppoets.newapp.Model.blog;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by user on 11/29/2017.
 */
public class BlogResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("error")
    private String error;
    @SerializedName("blogs")
    private List<Blogs> blogs;

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

    public List<Blogs> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blogs> blogs) {
        this.blogs = blogs;
    }
}
