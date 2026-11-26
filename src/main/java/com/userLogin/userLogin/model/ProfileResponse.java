package com.userLogin.userLogin.model;

public class ProfileResponse {
    private String username;
    private String roles;
    private Profile profile;

    public ProfileResponse(String username, String roles, Profile profile) {
        this.username = username;
        this.roles = roles;
        this.profile = profile;
    }

    public String getUsername() {
        return this.username;
    }

    public String getRoles() {
        return this.roles;
    }

    public Profile getProfile() {
        return this.profile;
    }


}
