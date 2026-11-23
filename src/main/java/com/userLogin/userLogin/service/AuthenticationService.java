package com.userLogin.userLogin.service;

import com.userLogin.userLogin.security.model.AuthenticationRequest;
import com.userLogin.userLogin.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}
