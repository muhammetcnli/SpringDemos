package com.atlas.cruddemo.dao;

import com.atlas.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{


    //define field for entitymanager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;


    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);


        // execute query and get result list
        List<Employee> employees = typedQuery.getResultList();

        // return the results

        return employees;
    }
}
