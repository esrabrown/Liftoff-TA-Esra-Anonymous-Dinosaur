package com.cafemanager.cafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private Integer id;

    private String firstName;

    private String lastName;

    private Boolean isSpecialDiet;

    private Double cafeteriaBalance;

    private String note;

    private Integer userId;


    //No arg constructor
    public  Student() {}

    //Constructor with parameter

    public Student(Integer id, String firstName, String lastName, Boolean isSpecialDiet, Double cafeteriaBalance, String note, Integer userId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isSpecialDiet = isSpecialDiet;
        this.cafeteriaBalance = cafeteriaBalance;
        this.note = note;
        this.userId = userId;
    }


    //Getter/setter

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

    public Boolean getSpecialDiet() {
        return isSpecialDiet;
    }

    public void setSpecialDiet(Boolean specialDiet) {
        isSpecialDiet = specialDiet;
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


    //to string method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isSpecialDiet=" + isSpecialDiet +
                ", cafeteriaBalance=" + cafeteriaBalance +
                ", note='" + note + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(isSpecialDiet, student.isSpecialDiet) && Objects.equals(getCafeteriaBalance(), student.getCafeteriaBalance()) && Objects.equals(getNote(), student.getNote()) && Objects.equals(getUserId(), student.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), isSpecialDiet, getCafeteriaBalance(), getNote(), getUserId());
    }
}




