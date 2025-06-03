package com.bootRestAP.RestApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class Welcome {
    @RequestMapping("/")
    @ResponseBody
    public String greet(){
        System.out.println("Working");
        return "Welcome to our Website";
    }
}
