package com.example.springbootproject.controller;

import com.example.springbootproject.model.Employee;
import com.example.springbootproject.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }

    @GetMapping
    public List<Employee> getAllEmployeeMethod(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long employeeid){

        return new ResponseEntity<>(employeeService.getEmployeeById(employeeid), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") long id,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployeeById(employee, id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployeeBYID(id);
        return new ResponseEntity<>("Employee deleted sucessfully",HttpStatus.OK);
    }
}
