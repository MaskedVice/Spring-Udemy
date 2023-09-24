package com.springudemy.springsecurity.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {
    
    @GetMapping(value="/")
    public String showHome() {
        return "home";
    }

    @GetMapping(value="/leaders")
    public String showLeaders() {
        return "leaders";
    }

    @GetMapping(value="/systems")
    public String showSystems() {
        return "systems";
    }
    
}
