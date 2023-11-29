package com.example.casestudy.dto;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Facility;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContractDto {
    //Lương, Giá, Tiền đặt cọc phải là số dương.
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    @Min(0)
    private double depost;
    private Customer customer;
    private Facility facility;


    public ContractDto() {
    }

    public ContractDto(Long id, LocalDate startDate, LocalDate endDate, double depost, Customer customer, Facility facility) {
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
}
