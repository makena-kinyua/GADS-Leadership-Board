package com.makena.gadsleaderboard.leaderboard.models;
import com.google.gson.annotations.SerializedName;

public class LearningHours {

    @SerializedName("name")
    private String name;
    @SerializedName("hours")
    private Integer hours;
    @SerializedName("country")
    private String country;
    @SerializedName("badgeUrl")
    private String badgeUrl;

    public LearningHours(String name, String badgeUrl, String country, int hours) {
        this.name = name;
        this.badgeUrl = badgeUrl;
        this.country = country;
        this.hours = hours;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBadgeUrl() {
        return badgeUrl;
    }
    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }

}
