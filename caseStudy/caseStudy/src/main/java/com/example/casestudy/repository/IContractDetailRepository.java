package com.example.casestudy.repository;

import com.example.casestudy.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
