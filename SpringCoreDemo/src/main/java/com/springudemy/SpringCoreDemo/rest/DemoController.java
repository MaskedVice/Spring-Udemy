package com.springudemy.SpringCoreDemo.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springudemy.SpringCoreDemo.common.Coach;

@RestController
public class DemoController {

    private Coach myCoach;
    
    @Autowired
    public DemoController( @Qualifier("swimCoach") Coach theCoach) {
        System.out.println("In Constructor of " + getClass().getSimpleName());
        myCoach = theCoach;    
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}