package com.springudemy.springsecurity.springsecurity.service;
import java.util.List;

import com.springudemy.springsecurity.springsecurity.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
