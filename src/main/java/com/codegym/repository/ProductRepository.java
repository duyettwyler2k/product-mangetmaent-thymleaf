package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository{
    private static Map<Integer,Product>products=new HashMap<>();
    static{
      products.put(1,new Product(1,"Tu lanh",1232100,"Lg"));
      products.put(2,new Product(2,"Ti vi",224300,"Lg232"));
      products.put(3,new Product(3,"lo vi song",22112000,"L232g"));
      products.put(4,new Product(4,"ban",20012300,"L4t4g"));
      products.put(5,new Product(5,"ghe",20232000,"Lg5y"));
      products.put(6,new Product(6,"noi com",2033333000,"L6yg"));
    }
    @Override
    public List<Product> findAll() {

        return new ArrayList<>(products.values());
    }

    @Override
    public Product create(Product product) {
        products.put(product.getId(),product);
        return product;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product update(int id, Product product) {
        products.replace(id,product);
        return products.get(id);
    }

    @Override
    public void remove(int id) {
      products.remove(id);
    }
}
