package com.example.casestudy.service;

import com.example.casestudy.model.FacilityType;
import com.example.casestudy.repository.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService{
    @Autowired
    IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(Long id) {
        return iFacilityTypeRepository.findById(id).orElse(null);
    }
}
