package com.userLogin.userLogin.controller;

import com.userLogin.userLogin.model.ProfileRequest;
import com.userLogin.userLogin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<?> getProfile(Principal principal) {
        try {
            return ResponseEntity.ok(profileService.getProfile(principal.getName()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<?>  createProfile(Principal principal, @RequestBody ProfileRequest profileRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(profileService.createProfile(principal.getName(), profileRequest));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @PutMapping
    @CrossOrigin
    public ResponseEntity<?> updateProfile(Principal principal, @RequestBody ProfileRequest profileRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(profileService.updateProfile(principal.getName(), profileRequest));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping
    @CrossOrigin
    public ResponseEntity<?> deleteProfile(Principal principal) {
        try {
            profileService.deleteProfile(principal.getName());
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}
