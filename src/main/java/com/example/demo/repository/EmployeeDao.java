package com.example.demo.repository;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployee();
    boolean deletePerson(int id);
    Employee updatePerson(Employee employee,int id);
    Employee findEmployeeById(int id);
    Employee addEmployee(Employee employee);

}
