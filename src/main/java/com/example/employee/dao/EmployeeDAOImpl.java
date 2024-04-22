package com.example.employee.dao;

import com.example.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{

    // create field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employeeIn) {
        entityManager.persist(employeeIn);
    }

    @Override
    public Employee findById(Integer employeeId) {
        return entityManager.find(Employee.class, employeeId);

    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("from Employee", Employee.class);
        return employeeTypedQuery.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String lastNameIn) {
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("From Employee where lastName =: lastname", Employee.class);
        employeeTypedQuery.setParameter("lastname", lastNameIn);
        return employeeTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Employee employeeIn) {
        entityManager.merge(employeeIn);
    }

    @Override
    @Transactional
    public void delete(Integer employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(employee);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted = entityManager.createQuery("Delete from Employee").executeUpdate();
        return  rowsDeleted;
    }
}
