package com.example.casestudy.dto;

import com.example.casestudy.model.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDate;

public class CustomerDto implements Validator {
    //Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải
    //viết hoa
    //Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc
    //(84)+90xxxxxxx hoặc (84)+91xxxxxxx.
    //4. Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX
    //(X là số 0-9).
    //Địa chỉ email phải đúng định dạng.
    private Long id;
    private CustomerType customerType;
    private String name;
    private LocalDate birth;
    private boolean gender;
    private String idCart;
    private String phoneNumber;
    private String email;
    private String address;

    public CustomerDto() {
    }

    public CustomerDto(Long id, CustomerType customerType, String name, LocalDate birth, boolean gender, String idCart, String phoneNumber, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.idCart = idCart;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if("".equals(customerDto.getName())){
            errors.rejectValue("name",null,"không đc để trống");
        } else if (!customerDto.getName().matches("^[a-zA-Z]*$")) {
            errors.rejectValue("name",null,"không đc chứa số");
        } else if(!customerDto.getName().matches("^[A-Z].*")){
            errors.rejectValue("name",null,"kí tự đầu tiên phải viết hoa");
        }
        if("".equals(customerDto.getPhoneNumber())){
            errors.rejectValue("phoneNumber",null,"không đc để trống");
        }else if(!customerDto.getPhoneNumber().matches("^((84)|(0))?(90|91)\\d{7}$")){
            errors.rejectValue("phoneNumber",null,"không đúng định dạng");
        }
        if("".equals(customerDto.getIdCart())){
            errors.rejectValue("idCart",null,"không đc để trống");
        }else if(!customerDto.getIdCart().matches("^\\d{9}$|^\\d{12}$")){
            errors.rejectValue("idCart",null,"không đúng định dạng");
        }
        if("".equals(customerDto.getEmail())){
            errors.rejectValue("email",null,"không đc để trống");
        }else if(!customerDto.getEmail().matches("^[a-zA-Z0-9]+@gmail.com$")){
            errors.rejectValue("email",null,"không đúng định dạng");
        }
    }
}
