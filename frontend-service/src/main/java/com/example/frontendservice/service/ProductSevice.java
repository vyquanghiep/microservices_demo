package com.example.frontendservice.service;

import com.example.frontendservice.model.Product;

import java.util.List;

public interface ProductSevice {
    Product saveProduct(Product product);
    List<Product> getProducts();

    Product getProductById(int id);

    List<Product> getByKeyword(String keyword);

    String deleteProduct(int id);


}

