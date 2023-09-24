package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public void createAccount() {
        // TODO Auto-generated method stub
        System.out.println("Creating account");    
    }
    
}
