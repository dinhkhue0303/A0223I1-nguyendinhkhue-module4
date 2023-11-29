package com.example.casestudy.service;

import com.example.casestudy.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
//    Page<ContractDtoInf> findContractByFacility(Pageable pageable, String name);
    Page<Contract> findContractByFacility(Pageable pageable, String name);
    Page<Contract> findAll(Pageable pageable);
    Page<Contract> findContractByCustomer(Pageable pageable, String name);
    void save(Contract contract);
    Contract findById(Long id);
    void remove(Long id);
}
