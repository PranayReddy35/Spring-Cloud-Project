package com.springcloudproject.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcloudproject.employeeapp.response.EmployeeResponse;
import com.springcloudproject.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {

		EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}

	@PostMapping("/employees")
	ResponseEntity<EmployeeResponse> addNewEmployee(@RequestBody EmployeeResponse empResponse) {
		EmployeeResponse employeeResponse = employeeService.saveEmployee(empResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
	}

}
