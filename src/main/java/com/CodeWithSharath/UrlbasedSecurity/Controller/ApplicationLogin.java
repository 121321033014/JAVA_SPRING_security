package com.CodeWithSharath.UrlbasedSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codewithsharath")
public class ApplicationLogin {
    @GetMapping("/login")
    public String great(){
        return "Hello Sharath welcome to codewithsharath website";

    }
}
