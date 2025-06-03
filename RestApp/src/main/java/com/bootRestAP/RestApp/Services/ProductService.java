package com.bootRestAP.RestApp.Services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootRestAP.RestApp.Models.Product;
import com.bootRestAP.RestApp.Repository.ProductRepository;

@Service
public class ProductService {
    //creating dummy product
    // List<Product> product = new ArrayList<>(Arrays.asList(
    //     new Product(101, "Iphone", 50000),
    //     new Product(102, "Canon Camera", 90000)
    // )); //ArrayList makes mutable list from immutable list of asList array
    @Autowired
    ProductRepository repo;
    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProduct(int productId){
        return repo.findById(productId).orElse(new Product(0,null,0));
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProduct(Product prod){
        repo.save(prod); //it check if data exist then update required fields or directly save
    }

    public void deleteProduct(int productId){
        repo.deleteById(productId);
    }
}
