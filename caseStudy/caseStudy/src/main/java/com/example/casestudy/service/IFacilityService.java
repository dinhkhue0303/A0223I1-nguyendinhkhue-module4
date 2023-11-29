package com.example.casestudy.service;

import com.example.casestudy.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();
    Page<Facility> findAll(Pageable pageable, String name);
    void save(Facility facility);
    Facility findById(Long id);
    void remove(Long id);
}
