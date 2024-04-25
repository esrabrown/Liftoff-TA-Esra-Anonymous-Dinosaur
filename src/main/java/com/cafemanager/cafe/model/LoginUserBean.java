package com.cafemanager.cafe.model;

import jakarta.validation.constraints.NotEmpty;

public class LoginUserBean {
@NotEmpty(message = "User Email must not be empty")
private String userEmail;

@NotEmpty(message = "User Password must not be empty")
private String userPassword;

//getters/Setters


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}