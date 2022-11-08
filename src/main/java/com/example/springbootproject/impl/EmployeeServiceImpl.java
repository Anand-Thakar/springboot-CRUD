package com.example.springbootproject.impl;

import com.example.springbootproject.exception.ResourceNotFoundException;
import com.example.springbootproject.model.Employee;
import com.example.springbootproject.repo.EmployeeRepository;
import com.example.springbootproject.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    public Employee getEmployeeById(long id) {
        Optional<Employee> emp = employeeRepository.findById(id);

/*        if (emp.isPresent()){
            return emp.get();
        }else {
            throw new ResourceNotFoundException("Employee","Id",id);
        }*/

        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployeeById(Employee employee, long id) {
        Employee exsitingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
        exsitingEmployee.setFirstName(employee.getFirstName());
        exsitingEmployee.setLastName(employee.getLastName());
        exsitingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(exsitingEmployee);
        return exsitingEmployee;

    }

    @Override
    public void deleteEmployeeBYID(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
        employeeRepository.delete(employee);
    }


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
