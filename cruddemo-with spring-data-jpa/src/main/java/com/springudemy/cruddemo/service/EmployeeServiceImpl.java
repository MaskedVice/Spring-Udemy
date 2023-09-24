package com.springudemy.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springudemy.cruddemo.dao.EmployeeRepository;
import com.springudemy.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> res = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if(theEmployee != null){
            theEmployee = res.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        
        return theEmployee;
    }
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
    
}
