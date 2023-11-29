package com.example.casestudy.repository;

import com.example.casestudy.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Long> {
}
