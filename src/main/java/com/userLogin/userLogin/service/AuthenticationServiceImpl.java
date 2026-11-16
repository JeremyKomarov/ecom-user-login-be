package com.userLogin.userLogin.service;

import com.userLogin.userLogin.security.CustomerUserDetailsService;
import com.userLogin.userLogin.security.model.AuthenticationRequest;
import com.userLogin.userLogin.security.model.AuthenticationResponse;
import com.userLogin.userLogin.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception exception) {
            throw new Exception("Incorrect Username or password");
        }

        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        return new AuthenticationResponse(jwtUtil.generateToken(userDetails));
    }
}
