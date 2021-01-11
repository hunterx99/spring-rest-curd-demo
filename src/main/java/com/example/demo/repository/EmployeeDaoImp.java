package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImp implements EmployeeDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Employee findEmployeeById(int id) {
        Employee employee=null;
        try {
            employee= (Employee) jdbcTemplate.queryForObject("select * from employee where id=?",new Object[]{id},new EmployeeMapper());

        }catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }
    @Override
    public List<Employee> getAllEmployee() {
        return jdbcTemplate.query("select * from employee",new EmployeeMapper());
    }

    @Override
    public boolean deletePerson(int id) {
        return jdbcTemplate.update("Delete from employee where id=?",id)>0;
    }

    @Override
    public Employee updatePerson(Employee employee,int id) {
         jdbcTemplate.update("update employee set name=?,email=?,address=? where id=?",
                employee.getName(),employee.getEmail(),employee.getAddress(),id);
        return findEmployeeById(employee.getId());
    }

    @Override
    public Employee addEmployee(Employee employee) {
         jdbcTemplate.update("insert into employee (id,name,email,address) values(?,?,?,?)",
                employee.getId(),employee.getName(),employee.getEmail(), employee.getAddress());
         return findEmployeeById(employee.getId());
    }
}
