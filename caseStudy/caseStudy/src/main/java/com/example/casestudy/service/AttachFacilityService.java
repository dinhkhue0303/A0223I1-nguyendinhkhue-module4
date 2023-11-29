package com.example.casestudy.service;

import com.example.casestudy.model.AttachFacility;
import com.example.casestudy.repository.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService{
    @Autowired
    IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacility> findAll(Long id) {
        return iAttachFacilityRepository.findAll(id);
    }

    @Override
    public List<AttachFacility> findAllNotIn(Long id) {
        return iAttachFacilityRepository.findAllNotIn(id);
    }
}
