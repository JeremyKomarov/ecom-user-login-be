package com.userLogin.userLogin.service;

import com.userLogin.userLogin.model.CustomerUser;
import com.userLogin.userLogin.model.CustomerUserRequest;
import com.userLogin.userLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(CustomerUserRequest customerUserRequest) throws Exception {
        CustomerUser existingUser = this.findUserByUsername(customerUserRequest.getUsername());
        if (existingUser != null) {
            throw new Exception("Username " + customerUserRequest.getUsername() + " is taken");
        }

        userRepository.createUser(customerUserRequest.toCustomerUser());
    }

    @Override
    public CustomerUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
