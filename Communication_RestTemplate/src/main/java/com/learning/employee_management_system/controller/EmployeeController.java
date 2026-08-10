package com.learning.employee_management_system.controller;

import com.learning.employee_management_system.model.Employee;
import com.learning.employee_management_system.service.EmployeeService;
import com.learning.employee_management_system.service.EmployeeServiceDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeServiceDao service;

    public EmployeeController(EmployeeServiceDao service) {
        this.service = service;
    }

    @PostMapping("/add")
    ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(service.addEmployee(employee),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    ResponseEntity<?> getAllEmployee(){
        return  new ResponseEntity<>(service.getAllEmployee(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(service.updateEmployee(id, employee), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> partialUpdateEmployee(@PathVariable Long id, @RequestBody Map<String, Object> update){
      return  new ResponseEntity<>(service.partialUpdateEmployee(id, update), HttpStatus.CREATED);
    }

    }

