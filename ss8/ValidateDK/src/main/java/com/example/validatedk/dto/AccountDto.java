package com.example.validatedk.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountDto {
    private int id;
    @Pattern(regexp = "^[a-zA-Z0-9]{1,}@gmail.com$",message = "email không hợp lệ")
    private String email;
    @Size(min = 5,max = 45)
    private String firstName;
    @Size(min = 5,max = 45)

    private String lastName;
    @Pattern(regexp = "^\\d{10}$", message = "số điện thoại không hợp lệ")
    private String phoneNumber;
    @Min(18)
    private int age;

    public AccountDto() {
    }

    public AccountDto(int id, String email, String firstName, String lastName, String phoneNumber, int age) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
