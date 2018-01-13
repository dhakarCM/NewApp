package com.phppoets.newapp.Model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

@SerializedName("id")
@Expose
private int id;
@SerializedName("company_id")
@Expose
private int companyId;
@SerializedName("member_name")
@Expose
private String memberName;
@SerializedName("member_nominee_type")
@Expose
private String memberNomineeType;
@SerializedName("email")
@Expose
private String email;
@SerializedName("exporter_email")
@Expose
private String exporterEmail;
@SerializedName("username")
@Expose
private String username;
@SerializedName("mobile_no")
@Expose
private String mobileNo;
@SerializedName("id_card_email")
@Expose
private int idCardEmail;
@SerializedName("passkey")
@Expose
private String passkey;
@SerializedName("timeout")
@Expose
private int timeout;
@SerializedName("member_flag")
@Expose
private int memberFlag;
@SerializedName("facebook_account")
@Expose
private String facebookAccount;
@SerializedName("gmail_account")
@Expose
private String gmailAccount;
@SerializedName("device_token")
@Expose
private String deviceToken;
@SerializedName("member_designation")
@Expose
private String memberDesignation;
@SerializedName("social_id")
@Expose
private String socialId;
@SerializedName("login_by")
@Expose
private String loginBy;
@SerializedName("fb_user_id")
@Expose
private String fbUserId;
@SerializedName("fb_token")
@Expose
private String fbToken;
@SerializedName("google_token")
@Expose
private String googleToken;
@SerializedName("google_auth")
@Expose
private String googleAuth;
@SerializedName("image")
@Expose
private String image;
@SerializedName("position")
@Expose
private String position;
@SerializedName("fax")
@Expose
private int fax;
@SerializedName("company")
@Expose
private Company company;
@SerializedName("members_image")
@Expose
private String membersImage;

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public int getCompanyId() {
return companyId;
}

public void setCompanyId(int companyId) {
this.companyId = companyId;
}

public String getMemberName() {
return memberName;
}

public void setMemberName(String memberName) {
this.memberName = memberName;
}

public String getMemberNomineeType() {
return memberNomineeType;
}

public void setMemberNomineeType(String memberNomineeType) {
this.memberNomineeType = memberNomineeType;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getExporterEmail() {
return exporterEmail;
}

public void setExporterEmail(String exporterEmail) {
this.exporterEmail = exporterEmail;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getMobileNo() {
return mobileNo;
}

public void setMobileNo(String mobileNo) {
this.mobileNo = mobileNo;
}

public int getIdCardEmail() {
return idCardEmail;
}

public void setIdCardEmail(int idCardEmail) {
this.idCardEmail = idCardEmail;
}

public String getPasskey() {
return passkey;
}

public void setPasskey(String passkey) {
this.passkey = passkey;
}

public int getTimeout() {
return timeout;
}

public void setTimeout(int timeout) {
this.timeout = timeout;
}

public int getMemberFlag() {
return memberFlag;
}

public void setMemberFlag(int memberFlag) {
this.memberFlag = memberFlag;
}

public String getFacebookAccount() {
return facebookAccount;
}

public void setFacebookAccount(String facebookAccount) {
this.facebookAccount = facebookAccount;
}

public String getGmailAccount() {
return gmailAccount;
}

public void setGmailAccount(String gmailAccount) {
this.gmailAccount = gmailAccount;
}

public String getDeviceToken() {
return deviceToken;
}

public void setDeviceToken(String deviceToken) {
this.deviceToken = deviceToken;
}

public String getMemberDesignation() {
return memberDesignation;
}

public void setMemberDesignation(String memberDesignation) {
this.memberDesignation = memberDesignation;
}

public String getSocialId() {
return socialId;
}

public void setSocialId(String socialId) {
this.socialId = socialId;
}

public String getLoginBy() {
return loginBy;
}

public void setLoginBy(String loginBy) {
this.loginBy = loginBy;
}

public String getFbUserId() {
return fbUserId;
}

public void setFbUserId(String fbUserId) {
this.fbUserId = fbUserId;
}

public String getFbToken() {
return fbToken;
}

public void setFbToken(String fbToken) {
this.fbToken = fbToken;
}

public String getGoogleToken() {
return googleToken;
}

public void setGoogleToken(String googleToken) {
this.googleToken = googleToken;
}

public String getGoogleAuth() {
return googleAuth;
}

public void setGoogleAuth(String googleAuth) {
this.googleAuth = googleAuth;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

public String getPosition() {
return position;
}

public void setPosition(String position) {
this.position = position;
}

public int getFax() {
return fax;
}

public void setFax(int fax) {
this.fax = fax;
}

public Company getCompany() {
return company;
}

public void setCompany(Company company) {
this.company = company;
}

public String getMembersImage() {
return membersImage;
}

public void setMembersImage(String membersImage) {
this.membersImage = membersImage;
}

}