package com.userLogin.userLogin.service;

import com.userLogin.userLogin.model.CustomerUser;
import com.userLogin.userLogin.model.Profile;
import com.userLogin.userLogin.model.ProfileRequest;
import com.userLogin.userLogin.model.ProfileResponse;
import com.userLogin.userLogin.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private UserService userService;

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public ProfileResponse getProfile(String username) throws Exception {
        CustomerUser customerUser = this.findExistingUser(username);
        Profile profile = profileRepository.getProfileByUserId(customerUser.getId());

        return new ProfileResponse(
                customerUser.getUsername(),
                customerUser.getRoles(),
                profile
        );
    }

    @Override
    public ProfileResponse createProfile(String username, ProfileRequest profileRequest) throws Exception {
        CustomerUser customerUser = this.findExistingUser(username);
        Profile customerProfile = profileRepository.getProfileByUserId(customerUser.getId());
        if (profileRepository.getProfileByUserId(customerUser.getId()) != null) {
            throw new Exception("Details already exist, use update instead");
        }

        profileRepository.createProfile(profileRequest.toProfile(customerUser.getId()));
        return this.getProfile(username);
    }

    @Override
    public ProfileResponse updateProfile(String username, ProfileRequest profileRequest) throws Exception {
        CustomerUser customerUser = this.findExistingUser(username);
        if (profileRepository.getProfileByUserId(customerUser.getId()) == null) {
            throw new Exception("No details to update, create them first");
        }

        profileRepository.updateProfile(profileRequest.toProfile(customerUser.getId()));
        return this.getProfile(username);
    }

    @Override
    public void deleteProfile(String username) throws Exception {
        CustomerUser customerUser = this.findExistingUser(username);
        if (profileRepository.getProfileByUserId(customerUser.getId()) == null) {
            throw new Exception("No details to delete");
        }

        profileRepository.deleteProfileByUserId(customerUser.getId());
    }

    private CustomerUser findExistingUser(String username) throws Exception {
        CustomerUser customerUser = userService.findUserByUsername(username);

        if (customerUser == null) {
            throw new Exception("User " + username + " not found");
        }

        return customerUser;
    }
}
