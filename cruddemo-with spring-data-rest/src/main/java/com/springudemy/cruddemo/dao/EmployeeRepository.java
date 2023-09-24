package com.springudemy.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springudemy.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { 
    
}
