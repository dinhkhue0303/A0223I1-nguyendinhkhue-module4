package com.example.casestudy.repository;

import com.example.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findCustomerByNameContaining(Pageable pageable, String searchName);
}
