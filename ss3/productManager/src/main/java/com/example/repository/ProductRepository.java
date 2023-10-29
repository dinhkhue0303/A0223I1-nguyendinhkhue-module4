package com.example.repository;

import com.example.model.Product;
import org.omg.PortableServer.POA;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> list = new ArrayList<>();
    static {
        list.add(new Product(1,"keo",2000,"con hang",new String[]{"VN"}));
        list.add(new Product(2,"sua",1000,"con hang",new String[]{"MY"}));
        list.add(new Product(3,"banh",5000,"het hang",new String[]{"NC"}));
    }
    @Override
    public List<Product> display() {
        return list;
    }

    @Override
    public void create(Product product) {
        list.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product p: list) {
            if(p.getId() == product.getId()){
                BeanUtils.copyProperties(product,p);
                System.out.println("hello");
            }
        }
    }

    @Override
    public void remove(int id) {;
        for (Product p:list) {
            if(p.getId() == id){
                int index = list.indexOf(p);
                list.remove(index);
                break;
            }
        }
    }
    @Override
    public List<Product> findName(String ten) {
        List<Product> list1 = new ArrayList<>();
        for (Product p: list) {
            if(p.getTen().equals(ten)){
                list1.add(p);
            }
        }
        return list1;
    }

    @Override
    public Product findById(int id) {
        for (Product p: list) {
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
}
