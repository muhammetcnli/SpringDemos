package com.atlas.cruddemo.service;

import com.atlas.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void delete(int theId);
}
