package com.springudemy.springsecurity.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springudemy.springsecurity.springsecurity.entity.User;

public interface UserService extends UserDetailsService {
    public User findUserByUsername(String username);
}
