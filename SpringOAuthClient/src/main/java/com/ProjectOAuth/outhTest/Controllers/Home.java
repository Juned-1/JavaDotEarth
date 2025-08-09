package com.ProjectOAuth.outhTest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public String greet(){
        return "Welcome to the OAuth Test Application!";
    }
}
