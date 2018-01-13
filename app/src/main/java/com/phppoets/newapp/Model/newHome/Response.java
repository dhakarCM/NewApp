package com.phppoets.newapp.Model.newHome;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("Slider")
    private List<Slider> slider;
    @SerializedName("HomeMenus")
    private List<Homemenus> homemenus;
    @SerializedName("Initiatives")
    private List<Initiatives> initiatives;
    @SerializedName("Advertisements")
    private List<Advertisements> advertisements;
    @SerializedName("Blogs")
    private List<Blogs> blogs;
    @SerializedName("Events")
    private List<Events> events;
    @SerializedName("GalleryPhotos")
    private List<Galleryphotos> galleryphotos;
    @SerializedName("AffilationRegistrations")
    private List<Affilationregistrations> affilationregistrations;

    public List<Slider> getSlider() {
        return slider;
    }

    public void setSlider(List<Slider> slider) {
        this.slider = slider;
    }

    public List<Homemenus> getHomemenus() {
        return homemenus;
    }

    public void setHomemenus(List<Homemenus> homemenus) {
        this.homemenus = homemenus;
    }

    public List<Initiatives> getInitiatives() {
        return initiatives;
    }

    public void setInitiatives(List<Initiatives> initiatives) {
        this.initiatives = initiatives;
    }

    public List<Advertisements> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisements> advertisements) {
        this.advertisements = advertisements;
    }

    public List<Blogs> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blogs> blogs) {
        this.blogs = blogs;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public List<Galleryphotos> getGalleryphotos() {
        return galleryphotos;
    }

    public void setGalleryphotos(List<Galleryphotos> galleryphotos) {
        this.galleryphotos = galleryphotos;
    }

    public List<Affilationregistrations> getAffilationregistrations() {
        return affilationregistrations;
    }

    public void setAffilationregistrations(List<Affilationregistrations> affilationregistrations) {
        this.affilationregistrations = affilationregistrations;
    }
}
