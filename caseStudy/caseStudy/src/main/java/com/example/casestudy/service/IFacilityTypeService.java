package com.example.casestudy.service;

import com.example.casestudy.model.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
    FacilityType findById(Long id);
}
