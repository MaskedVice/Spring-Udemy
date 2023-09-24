package com.springudemy.springsecurity.springsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springudemy.springsecurity.springsecurity.dao.EmployeeRepository;
import com.springudemy.springsecurity.springsecurity.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeRepository.findById(theId).orElse(null);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

}
