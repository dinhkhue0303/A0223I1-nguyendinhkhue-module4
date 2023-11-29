package com.example.casestudy.dto;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Facility;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

public class ContractDto {
    //Lương, Giá, Tiền đặt cọc phải là số dương.
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Min(0)
    private double depost;
    private Customer customer;
    private Facility facility;


    public ContractDto() {
    }

    public ContractDto(Long id, LocalDateTime startDate, LocalDateTime endDate, double depost, Customer customer, Facility facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.depost = depost;
        this.customer = customer;
        this.facility = facility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(LocalDateTime endDate) {
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
}
