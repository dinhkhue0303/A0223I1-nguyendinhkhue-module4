package com.example.casestudy.dto;

import com.example.casestudy.model.AttachFacility;
import com.example.casestudy.model.Contract;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

public class ContractDetailDto {
    //Số lượng phải là số nguyên dương.
    private Long id;

    private Contract contract;

    private AttachFacility attachFacility;
    @Min(0)
    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Long id, Contract contract, AttachFacility attachFacility, int quantity) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
