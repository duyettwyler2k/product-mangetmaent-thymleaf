package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product create(Product product);
    Product findById(int id);
    Product update(int id,Product product);
    void remove(int id);
}
