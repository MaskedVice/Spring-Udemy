package com.springudemy.SpringCoreDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springudemy.SpringCoreDemo.common.Coach;
import com.springudemy.SpringCoreDemo.common.SwimCoach;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
