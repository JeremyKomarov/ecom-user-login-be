package com.userLogin.userLogin.repository;

import com.userLogin.userLogin.model.Profile;

public interface ProfileRepository {
    void createProfile(Profile profile);
    Profile getProfileByUserId(Long userId);
    void updateProfile(Profile profile);
    void  deleteProfileByUserId(Long userId);
}
