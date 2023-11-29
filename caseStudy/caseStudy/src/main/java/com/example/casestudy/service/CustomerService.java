package com.example.casestudy.service;

import com.example.casestudy.model.Customer;
import com.example.casestudy.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable, String name) {
        return iCustomerRepository.findCustomerByNameContaining(pageable,name);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }
}
