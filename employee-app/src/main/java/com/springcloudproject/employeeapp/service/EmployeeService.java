package com.springcloudproject.employeeapp.service;


import com.springcloudproject.employeeapp.response.EmployeeResponse;

public interface EmployeeService {

	EmployeeResponse getEmployeeById(int id);

	EmployeeResponse saveEmployee(EmployeeResponse empResponse);

}
