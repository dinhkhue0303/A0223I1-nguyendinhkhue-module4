package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenBaiHat;
    private String ngheSi;
    private String theLoai;
    private String URL;

    public Music() {
    }

    public Music(String tenBaiHat, String ngheSi, String theLoai, String URL) {
        this.tenBaiHat = tenBaiHat;
        this.ngheSi = ngheSi;
        this.theLoai = theLoai;
        this.URL = URL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
