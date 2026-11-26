package com.userLogin.userLogin.service;

import com.userLogin.userLogin.model.ProfileRequest;
import com.userLogin.userLogin.model.ProfileResponse;

public interface ProfileService {
    ProfileResponse getProfile(String username) throws Exception;
    ProfileResponse createProfile(String username, ProfileRequest profileRequest) throws Exception;
    ProfileResponse updateProfile(String username, ProfileRequest profileRequest) throws Exception;
    void deleteProfile(String username) throws Exception;
}
