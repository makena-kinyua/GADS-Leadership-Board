package com.makena.gadsleaderboard.leaderboard.models;
import com.google.gson.annotations.SerializedName;

public class LearningScore {

    @SerializedName("name")
    private String name;
    @SerializedName("score")
    private Integer score;
    @SerializedName("country")
    private String country;
    @SerializedName("badgeUrl")
    private String badgeUrl;

    public LearningScore(String name, String badgeUrl, String country, int score) {
        this.name = name;
        this.badgeUrl = badgeUrl;
        this.country = country;
        this.score = score;
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
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

}
