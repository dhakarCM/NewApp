package com.phppoets.newapp.Model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

@SerializedName("success")
@Expose
private boolean success;
@SerializedName("error")
@Expose
private String error;
@SerializedName("user")
@Expose
private User user;

public boolean isSuccess() {
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

public User getUser() {
return user;
}

public void setUser(User user) {
this.user = user;
}

}