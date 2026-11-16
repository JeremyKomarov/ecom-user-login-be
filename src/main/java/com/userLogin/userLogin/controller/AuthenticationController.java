package com.userLogin.userLogin.controller;

import com.userLogin.userLogin.security.model.AuthenticationRequest;
import com.userLogin.userLogin.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    @CrossOrigin
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            return ResponseEntity.ok(authenticationService.createAuthenticationToken(authenticationRequest));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Incorrect User Or password");
        }
    }
}
