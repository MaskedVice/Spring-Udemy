package com.springudemy.SpringCoreDemo.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return"Spend 30 minutes batting practice";
    }
    
    
}
