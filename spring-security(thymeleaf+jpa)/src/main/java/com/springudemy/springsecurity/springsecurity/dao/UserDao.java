package com.springudemy.springsecurity.springsecurity.dao;

import com.springudemy.springsecurity.springsecurity.entity.User;

public interface UserDao {
    User findByUserName(String username);
}
