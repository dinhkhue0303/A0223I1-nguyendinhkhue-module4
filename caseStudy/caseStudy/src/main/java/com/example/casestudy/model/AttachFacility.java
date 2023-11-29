package com.example.casestudy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;
    private String unit;
    private String status;
    @OneToMany(mappedBy = "attachFacility", cascade = CascadeType.ALL)
    Set<ContractDetail> contratDetailSetl;

    public AttachFacility() {
    }

    public AttachFacility(Long id, String name, double cost, String unit, String status, Set<ContractDetail> contratDetailSetl) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contratDetailSetl = contratDetailSetl;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContratDetailSetl() {
        return contratDetailSetl;
    }

    public void setContratDetailSetl(Set<ContractDetail> contratDetailSetl) {
        this.contratDetailSetl = contratDetailSetl;
    }
}
