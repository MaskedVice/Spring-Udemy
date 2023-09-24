package com.springudemy.springsecurity.springsecurity.dao;

import com.springudemy.springsecurity.springsecurity.entity.Role;

public interface RoleDao {
	public Role findRoleByName(String theRoleName);
}

