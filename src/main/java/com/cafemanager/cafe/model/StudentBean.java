package com.cafemanager.cafe.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class StudentBean {

    @NotNull(message = "student id must not be empty")
    private int studentId;

    @NotEmpty(message = "User Firstname must not be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Pattern(regexp="^[A-Za-z]*$", message="Numbers are not allowed")
    private String firstName;

    @NotEmpty(message = "User Lastname must not be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Pattern(regexp="^[A-Za-z]*$", message="Numbers are not allowed")
    private String lastName;

    private Double cafeteriaBalance;

    @Size(max = 255, message = "Description too long!")
    private String note;

    private int userId;


    //getter/setter

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public Double getCafeteriaBalance() {
        return cafeteriaBalance;
    }

    public void setCafeteriaBalance(Double cafeteriaBalance) {
        this.cafeteriaBalance = cafeteriaBalance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

