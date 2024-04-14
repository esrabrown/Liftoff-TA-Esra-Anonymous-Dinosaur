package com.cafemanager.cafe.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentBean {


    private Integer id;

    @NotEmpty(message = "User Firstname must not be empty")
    private String firstName;

    @NotEmpty(message = "User Lastname must not be empty")
    private String lastName;

    private boolean specialDiet;

    private Double cafeteriaBalance;

    private String note;

    @NotNull
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean getSpecialDiet() {
        return specialDiet;
    }

    public void setSpecialDiet(boolean specialDiet) {
        this.specialDiet = specialDiet;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
