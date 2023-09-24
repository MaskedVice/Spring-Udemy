package com.springudemy.springsecurity.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "fancy-login";
    }

    //request mapping for access-denied page
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }


}
