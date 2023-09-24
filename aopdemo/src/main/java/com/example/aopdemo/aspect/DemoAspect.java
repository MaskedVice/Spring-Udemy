package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {
    

    @Before("execution(public void createAccount())")
    public void beforeAdvice(){
        System.out.println("\n====before advice");
    }
}
