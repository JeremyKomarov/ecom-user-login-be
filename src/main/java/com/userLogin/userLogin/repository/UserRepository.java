package com.userLogin.userLogin.repository;

import com.userLogin.userLogin.model.CustomerUser;

public interface UserRepository {
    void createUser(CustomerUser customerUser);
    CustomerUser findUserByUsername(String username);
}
