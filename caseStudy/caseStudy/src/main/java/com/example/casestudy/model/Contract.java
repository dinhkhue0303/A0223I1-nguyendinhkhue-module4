package com.example.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double depost;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    Set<ContractDetail> contractDetailSet;

    public Contract() {
    }

    public Contract(Long id, LocalDate startDate, LocalDate endDate, double depost, Customer customer, Facility facility, Set<ContractDetail> contractDetailSet) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.depost = depost;
        this.customer = customer;
        this.facility = facility;
        this.contractDetailSet = contractDetailSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public double getDepost() {
        return depost;
    }

    public void setDepost(double depost) {
        this.depost = depost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
