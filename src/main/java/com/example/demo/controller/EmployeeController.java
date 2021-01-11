package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeDao;
import com.example.demo.repository.EmployeeDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/employee")
    List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployee();
    }
    @DeleteMapping("/employee/{id}")
    boolean deleteEmployee(@PathVariable Integer id){
        return employeeDao.deletePerson(id);
    }
    @PutMapping("/employee/{id}")
    Employee updateEmployee(@RequestBody Employee employee,@PathVariable Integer id){
        return  employeeDao.updatePerson(employee,id);
    }
    @GetMapping("/employee/{id}")
    Employee findEmployeeById(@PathVariable Integer id) throws Exception{
        Employee employee=employeeDao.findEmployeeById(id);
        if(employee==null) throw new Exception("No Employee found by"+id);
        return employee;
    }
    @PostMapping("/addEmployee")
    Employee addEmployee(@RequestBody Employee employee){
        return  employeeDao.addEmployee(employee);
    }

}
