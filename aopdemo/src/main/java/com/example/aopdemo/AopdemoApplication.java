package com.example.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.aopdemo.dao.AccountDao;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(AccountDao accountDao){
		return runner ->{
				demoTheBeforeAdvice(accountDao);
		};
	}
	
	private void demoTheBeforeAdvice(AccountDao accountDao) {
		accountDao.createAccount();
	}

}

	
