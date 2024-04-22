package com.example.employee.dao;

import com.example.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // create employee
    void save(Employee employeeIn);

    // retrieve
    Employee findById(Integer employeeId);
    List<Employee> findAll ();
    List<Employee> findByLastName (String lastNameIn);

    // update
    void update(Employee employeeIn);

    // delete
    void delete (Integer employeeId);

    int deleteAll();
}
