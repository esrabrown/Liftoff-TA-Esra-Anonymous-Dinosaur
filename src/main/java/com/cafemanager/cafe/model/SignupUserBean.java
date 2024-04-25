package com.cafemanager.cafe.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SignupUserBean {
private int userId;

@NotEmpty(message = "User Firstname must not be empty")
@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
@Pattern(regexp="^[A-Za-z]*$", message="Numbers are not allowed")
private String firstName;

@NotEmpty(message = "User Lastname must not be empty")
@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
@Pattern(regexp="^[A-Za-z]*$", message="Numbers are not allowed")
private String lastName;


@NotEmpty(message = "User Email must not be empty")
@Email(message = "Invalid email. Try again.")
private String userEmail;

@NotEmpty(message = "User Password must not be empty")
private String userPassword;


@NotEmpty(message = "User Confirm Password must not be empty")
private String confirmPassword;

//getter/setter


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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




