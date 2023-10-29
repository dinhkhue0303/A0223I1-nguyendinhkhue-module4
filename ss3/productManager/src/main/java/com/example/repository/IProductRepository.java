package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> display();
    void create(Product product);
    void update(Product product);
    void remove(int id);
    List<Product> findName(String ten);
    Product findById(int id);
}
