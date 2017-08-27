package com.example.g6ix.search_developer.DevActivities;

/**
 * Created by g6ix on 21-Aug-17.
 */

public class Developers {
    private String mNames;
    private String mImageUrl;
    private String mGithubUrl;

    public Developers(String mNames, String mImageUrl, String mGithubUrl) {
        this.mNames = mNames;
        this.mImageUrl = mImageUrl;
        this.mGithubUrl = mGithubUrl;
    }

    public String getmNames() {
        return mNames;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmGithubUrl() {
        return mGithubUrl;
    }
}