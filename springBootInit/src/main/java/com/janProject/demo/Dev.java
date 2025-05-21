package com.janProject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    //@Autowired //field injection
    //Laptop laptop;
    // public Dev(Laptop laptop){
    //     this.laptop = laptop;
    // }

    private Computer comp;
    @Autowired
    @Qualifier("laptop")
    public void setLaptop(Computer comp){
        this.comp = comp;
    }
    public void build(){
        comp.compile();
        System.out.println("Working on this awesome project");
    }
}
