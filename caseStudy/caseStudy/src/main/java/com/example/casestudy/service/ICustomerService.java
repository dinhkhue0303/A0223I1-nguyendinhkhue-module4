package com.example.casestudy.service;

import com.example.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable, String name);
    void save(Customer customer);
    Customer findById(Long id);
    void remove(Long id);
}
