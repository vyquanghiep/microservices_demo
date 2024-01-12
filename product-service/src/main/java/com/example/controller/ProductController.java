package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductSevice productSevice;

    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product) {
        productSevice.saveProduct(product);
    }

    @GetMapping("/")
    public List<Product> findAllProduct() {
        return productSevice.getProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") Integer id) {
        return productSevice.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable("id") Integer id) {
        productSevice.deleteProduct(id);
    }
}
