package com.example.casestudy.repository;

import com.example.casestudy.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Long> {
    @Query(value = "select af.id, af.cost, af.name, af.status, af.unit from " +
            "contract ct join contract_detail ctd " +
            "on ct.id = ctd.contract_id " +
            "join attach_facility af " +
            "on af.id = ctd.attach_facility_id " +
            "where ct.id like :id",nativeQuery = true)
    List<AttachFacility> findAll(@Param("id") Long id);

    @Query(value = "select af.id, af.cost, af.name, af.status, af.unit " +
            "from attach_facility af " +
            "where af.name not in ( " +
            "select af.name from " +
            "contract ct join contract_detail ctd " +
            "on ct.id = ctd.contract_id " +
            "join attach_facility af " +
            "on af.id = ctd.attach_facility_id " +
            "where ct.id like :id " +
            ")",nativeQuery = true)
    List<AttachFacility> findAllNotIn(@Param("id") Long id);
}
