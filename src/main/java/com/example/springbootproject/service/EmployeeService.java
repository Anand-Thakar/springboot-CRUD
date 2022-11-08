package com.example.springbootproject.service;

import com.example.springbootproject.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();

    Employee getEmployeeById(long id);

    Employee updateEmployeeById(Employee employee,long id);

    void deleteEmployeeBYID(long id);
}
