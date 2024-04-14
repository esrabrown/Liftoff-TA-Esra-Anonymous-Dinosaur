package com.cafemanager.cafe.model;

import jakarta.validation.constraints.NotEmpty;

public class SignupUserBean {
private int id;

@NotEmpty(message = "User Firstname must not be empty")
private String firstName;

@NotEmpty(message = "User Lastname must not be empty")
private String lastName;

@NotEmpty(message = "User Email must not be empty")
private String userEmail;

@NotEmpty(message = "User Password must not be empty")
private String userPassword;


@NotEmpty(message = "User Confirm Password must not be empty")
private String confirmPassword;

//getter/setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}


