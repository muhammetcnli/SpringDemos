package com.atlas.cruddemo.dao;

import com.atlas.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
