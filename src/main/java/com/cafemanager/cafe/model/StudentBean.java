package com.cafemanager.cafe.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentBean {


    @NotNull(message = "student id must not be empty")
    private int studentId;

    @NotEmpty(message = "User Firstname must not be empty")
    private String firstName;

    @NotEmpty(message = "User Lastname must not be empty")
    private String lastName;

    private Double cafeteriaBalance;

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



