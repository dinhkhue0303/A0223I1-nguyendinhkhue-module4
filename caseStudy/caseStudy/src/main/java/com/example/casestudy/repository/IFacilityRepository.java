package com.example.casestudy.repository;

import com.example.casestudy.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Long> {
    Page<Facility> findFacilityByNameContaining(Pageable pageable, String searchName);
}
