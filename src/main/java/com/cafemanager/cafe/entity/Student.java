package com.cafemanager.cafe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)


    private Integer studentId;

    private String firstName;

    private String lastName;

    private Double cafeteriaBalance;

    private String note;

    @ManyToOne
    @NotNull()
    @JoinColumn(name = "user_Id")
    private User user;

   //No Arg Constructor

    public Student() {
    }

    //constructor with argument

    public Student(Integer studentId, String firstName, String lastName, Double cafeteriaBalance, String note, User user) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cafeteriaBalance = cafeteriaBalance;
        this.note = note;
        this.user = user;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNote(String note) {
        this.note = note;

    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cafeteriaBalance=" + cafeteriaBalance +
                ", note='" + note + '\'' +
    //            ", user=" + user +
                ", userId=" + (user != null ? user.getUserId() : null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getStudentId(), student.getStudentId()) && Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getCafeteriaBalance(), student.getCafeteriaBalance()) && Objects.equals(getNote(), student.getNote()) && Objects.equals(getUser(), student.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFirstName(), getLastName(), getCafeteriaBalance(), getNote(), getUser());
    }
}




