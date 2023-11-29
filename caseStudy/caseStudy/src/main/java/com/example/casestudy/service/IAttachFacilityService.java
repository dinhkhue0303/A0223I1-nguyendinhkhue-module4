package com.example.casestudy.service;

import com.example.casestudy.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll(Long id);
    List<AttachFacility> findAllNotIn(Long id);
}
