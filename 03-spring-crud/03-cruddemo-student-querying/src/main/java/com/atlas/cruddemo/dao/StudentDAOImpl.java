package com.atlas.cruddemo.dao;

import com.atlas.cruddemo.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{


    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return  entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        // return query results
         return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);

        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {

        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
