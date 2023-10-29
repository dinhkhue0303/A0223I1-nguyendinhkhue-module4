package com.example.model;

public class Product {
    private int id;
    private String ten;
    private double gia;
    private String moTa;
    private String[] nhaSX;

    public Product() {
    }

    public Product(int id, String ten, double gia, String moTa, String[] nhaSX) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.nhaSX = nhaSX;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String[] getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String[] nhaSX) {
        this.nhaSX = nhaSX;
    }
}
