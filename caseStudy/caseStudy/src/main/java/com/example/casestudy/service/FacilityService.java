package com.example.casestudy.service;

import com.example.casestudy.model.Facility;
import com.example.casestudy.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService{
    @Autowired
    IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Page<Facility> findAll(Pageable pageable, String name) {
        return iFacilityRepository.findFacilityByNameContaining(pageable,name);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(Long id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        iFacilityRepository.deleteById(id);
    }
}
