package com.example.casestudy.repository;

import com.example.casestudy.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "select co.id, co.start_date, co.end_date, co.depost, co.customer_id,  co.facility_id " +
            "from contract co " +
            "join customer cu " +
            "on co.customer_id = cu.id " +
            "where cu.name like :name", nativeQuery = true)
    Page<Contract> findContractByFacility(Pageable pageable, @Param("name") String name);

    Page<Contract> findAll(Pageable pageable);
    @Query(value = "select * from contract c join customer ct on c.customer_id = ct.id join facility f" +
            " on c.facility_id = f.id where ct.name like :name",nativeQuery = true)
    Page<Contract> findContractByCustomer(Pageable pageable, @Param("name") String name);

    Page<Contract> findContractByFacility_Name(Pageable pageable, String name);
}
