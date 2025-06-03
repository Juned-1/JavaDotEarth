package com.bootRestAP.RestApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootRestAP.RestApp.Models.Product;
import com.bootRestAP.RestApp.Services.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService service;
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product geProduct(@PathVariable int productId){
        return service.getProduct(productId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        //System.out.println(prod);
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable("prodId") int productId){
        service.deleteProduct(productId);
    }
}