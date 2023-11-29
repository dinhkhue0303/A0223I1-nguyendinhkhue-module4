package com.example.casestudy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "facilityType", cascade = CascadeType.ALL)
    Set<Facility> facilitySet;

    public FacilityType() {
    }

    public FacilityType(Long id, String name, Set<Facility> facilitySet) {
        this.id = id;
        this.name = name;
        this.facilitySet = facilitySet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }
}
