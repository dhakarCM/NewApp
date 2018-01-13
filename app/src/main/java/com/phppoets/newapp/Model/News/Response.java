package com.phppoets.newapp.Model.News;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("cover_image")
    private String coverImage;
    @SerializedName("pdf_attachment")
    private String pdfAttachment;
    @SerializedName("description")
    private String description;
    @SerializedName("created_on")
    private String createdOn;
    @SerializedName("created_by")
    private int createdBy;
    @SerializedName("edited_on")
    private String editedOn;
    @SerializedName("edited_by")
    private int editedBy;
    @SerializedName("is_deleted")
    private int isDeleted;
    @SerializedName("cover_image_fullpath")
    private String coverImageFullpath;
    @SerializedName("attachment_fullpath")
    private String attachmentFullpath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getPdfAttachment() {
        return pdfAttachment;
    }

    public void setPdfAttachment(String pdfAttachment) {
        this.pdfAttachment = pdfAttachment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCoverImageFullpath() {
        return coverImageFullpath;
    }

    public void setCoverImageFullpath(String coverImageFullpath) {
        this.coverImageFullpath = coverImageFullpath;
    }

    public String getAttachmentFullpath() {
        return attachmentFullpath;
    }

    public void setAttachmentFullpath(String attachmentFullpath) {
        this.attachmentFullpath = attachmentFullpath;
    }
}
