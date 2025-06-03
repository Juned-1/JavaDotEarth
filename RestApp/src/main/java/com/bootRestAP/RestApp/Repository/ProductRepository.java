package com.bootRestAP.RestApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootRestAP.RestApp.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
