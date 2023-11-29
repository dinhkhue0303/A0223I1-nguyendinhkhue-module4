package com.example.casestudy.service;

import com.example.casestudy.model.Contract;
import com.example.casestudy.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService{
    @Autowired
    IContractRepository iContractRepository;
//    @Override
//    public Page<ContractDtoInf> findContractByFacility(Pageable pageable, String name) {
//        return iContractRepository.findContractByFacility(pageable,"%"+name.trim()+"%");
//    }

    @Override
    public Page<Contract> findContractByFacility(Pageable pageable, String name) {
        return iContractRepository.findContractByFacility(pageable,"%"+name.trim()+"%");
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findContractByCustomer(Pageable pageable, String name) {
        return iContractRepository.findContractByCustomer(pageable,name);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Contract findById(Long id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        iContractRepository.deleteById(id);
    }
}
