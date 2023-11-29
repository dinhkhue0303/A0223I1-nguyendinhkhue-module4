package com.example.casestudy.service;

import com.example.casestudy.model.ContractDetail;
import com.example.casestudy.repository.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService{
    @Autowired
    IContractDetailRepository iContractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
