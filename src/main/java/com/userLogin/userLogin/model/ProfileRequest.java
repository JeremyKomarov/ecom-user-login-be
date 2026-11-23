package com.userLogin.userLogin.model;

public class ProfileRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public ProfileRequest(String firstName, String lastName, String email, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Profile toProfile(Long userId) {
        return new Profile(
                userId,
                this.getFirstName(),
                this.getLastName(),
                this.getEmail(),
                this.getPhone(),
                this.getAddress()
        );
    }
}
