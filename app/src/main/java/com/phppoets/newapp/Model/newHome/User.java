package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private int id;
    @SerializedName("member_name")
    private String memberName;
    @SerializedName("email")
    private String email;
    @SerializedName("members_image")
    private String membersImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembersImage() {
        return membersImage;
    }

    public void setMembersImage(String membersImage) {
        this.membersImage = membersImage;
    }
}
