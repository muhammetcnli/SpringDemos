package com.atlas.cruddemo.service;

import com.atlas.cruddemo.dao.EmployeeDAO;
import com.atlas.cruddemo.dao.EmployeeDAOImpl;
import com.atlas.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){

        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
