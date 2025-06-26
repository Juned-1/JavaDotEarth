package com.SpringSecurity.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Hello {

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome Boss " + request.getSession().getId();
    }
}
