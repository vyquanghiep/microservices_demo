package com.example.frontendservice.service;

import com.example.frontendservice.model.Product;
import com.example.frontendservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceIml implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Sản phẩm remove ||" + id;
    }
    @Override
    public List<Product> getByKeyword(String keyword) {
        return productRepository.findByKeyword(keyword);
    }
}
