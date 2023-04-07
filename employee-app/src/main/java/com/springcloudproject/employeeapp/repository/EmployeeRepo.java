package com.springcloudproject.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloudproject.employeeapp.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
