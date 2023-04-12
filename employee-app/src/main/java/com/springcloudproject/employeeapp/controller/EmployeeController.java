package com.springcloudproject.employeeapp.controller;

import com.springcloudproject.employeeapp.response.EmployeeResponse;
import com.springcloudproject.employeeapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
        log.info("Getting employee with id : {}", id);
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @PostMapping("/employees")
    ResponseEntity<EmployeeResponse> addNewEmployee(@RequestBody EmployeeResponse empResponse) {
        log.info("Creating a new employee with details : {}", empResponse);
        EmployeeResponse employeeResponse = employeeService.saveEmployee(empResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }

}
