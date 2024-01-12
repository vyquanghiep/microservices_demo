package com.example.frontendservice.controller;

import com.example.frontendservice.model.Product;
import com.example.frontendservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/front")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/showProduct")
    public String ShowProduct(Model model, @Param("keyword") String keyword){
        if(keyword!=null) {
            List<Product> listProducts = productService.getByKeyword(keyword);
            model.addAttribute("listProducts", listProducts);
        }else {
            List<Product> listProducts = productService.getProducts();
            model.addAttribute("listProducts", listProducts);}
        return "Product";
    }
    @GetMapping("/addProduct")
    public String AddProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "AddProduct";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/front/showProduct";

    }
    @GetMapping("/editProduct/{id}")
    public String updateProduct(@PathVariable (value = "id") int id, Model model){
        Product product = productService.getProductById( id);
        model.addAttribute("product",product);
        return "AddProduct";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") int id){
        productService.deleteProduct(id);
        return "redirect:/front/showProduct";
    }
}
