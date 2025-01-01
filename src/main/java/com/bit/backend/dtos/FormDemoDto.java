package com.bit.backend.dtos;

import java.util.Date;
import java.util.List;

public class FormDemoDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String gender;
    private String food;
    private Date dob;
    private List<Boolean> check;

    public FormDemoDto() {}

    public FormDemoDto(Long id, String firstName, String lastName, String email, int age, String gender, String food, Date dob, List check) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.food = food;
        this.dob = dob;
        this.check = check;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Boolean> getCheck() {
        return check;
    }

    public void setCheck(List<Boolean> check) {
        this.check = check;
    }
}
