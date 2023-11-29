package com.example.casestudy.repository;

import com.example.casestudy.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Long> {
}
