package com.userLogin.userLogin.model;

public class CustomerUserRequest {
    private String username;
    private String password;

    public CustomerUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerUser toCustomerUser() {
        return new CustomerUser(
                null,
                this.getUsername(),
                this.getPassword(),
                ""
        );
    }
}
