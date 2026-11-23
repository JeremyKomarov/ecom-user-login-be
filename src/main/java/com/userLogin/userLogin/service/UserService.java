package com.userLogin.userLogin.service;

import com.userLogin.userLogin.model.CustomerUser;
import com.userLogin.userLogin.model.CustomerUserRequest;

public interface UserService {
    void createUser(CustomerUserRequest customerUserRequest) throws Exception;
    CustomerUser findUserByUsername(String username);
}
