package com.example.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    private String name;
    private LocalDate birth;
    private boolean gender;
    private String idCart;
    private String phoneNumber;
    private String email;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    Set<Contract> contractset;

    public Customer() {
    }

    public Customer(Long id, CustomerType customerType, String name, LocalDate birth, boolean gender, String idCart, String phoneNumber, String email, String address, Set<Contract> contractset) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.idCart = idCart;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.contractset = contractset;
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

    public Set<Contract> getContractset() {
        return contractset;
    }

    public void setContractset(Set<Contract> contractset) {
        this.contractset = contractset;
    }
}
