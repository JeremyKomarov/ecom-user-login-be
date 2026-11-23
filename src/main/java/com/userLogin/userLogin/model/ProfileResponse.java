package com.userLogin.userLogin.model;

public class ProfileResponse {
    private String username;
    private Profile profile;

    public ProfileResponse(String username, Profile profile) {
        this.username = username;
        this.profile = profile;
    }

    public String getUsername() {
        return this.username;
    }

    public Profile getProfile() {
        return this.profile;
    }
}
