package com.example.casestudy.dto;

import com.example.casestudy.model.FacilityType;
import com.example.casestudy.model.RentType;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class FacilityDto {
    //Tên dịch vụ được phép chứa số. Và các kí tự đầu tiên của mỗi từ phải viết
    //hoa
    //Số tầng phải là số nguyên dương.
    //Lương, Giá, Tiền đặt cọc phải là số dương.
    private Long id;
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$", message = "định dạng không hợp lệ")
    private String name;
    private double area;
    @Min(0)
    private double cost;
    private int max_people;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String decription;
    private double poolArea;
    @Min(0)
    private int numberOfFloor;
    private String facilityFree;

    public FacilityDto() {
    }

    public FacilityDto(Long id, String name, double area, double cost, int max_people, RentType rentType, FacilityType facilityType, String standardRoom, String decription, double poolArea, int numberOfFloor, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.decription = decription;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }
}
