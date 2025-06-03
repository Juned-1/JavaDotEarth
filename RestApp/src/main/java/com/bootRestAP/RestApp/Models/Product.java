package com.bootRestAP.RestApp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Comes from Lombok
@AllArgsConstructor //allows to set product details using constructor -- Lombok
@NoArgsConstructor
//It is palin POJO or JPA object, it does not have to be Component
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
}
