package com.example.casestudy.repository;

import com.example.casestudy.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
