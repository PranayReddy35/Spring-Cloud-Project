package com.springcloudproject.employeeapp.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloudproject.employeeapp.entity.Employee;
import com.springcloudproject.employeeapp.repository.EmployeeRepo;
import com.springcloudproject.employeeapp.response.EmployeeResponse;
import com.springcloudproject.employeeapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeResponse getEmployeeById(int id) {

		Employee employee = employeeRepo.findById(id).get();
		EmployeeResponse employeeResponse=modelMapper.map(employee, EmployeeResponse.class);
		return employeeResponse;
	}

	@Override
	public EmployeeResponse saveEmployee(EmployeeResponse empResponse) {
		Employee employee=modelMapper.map(empResponse, Employee.class);
		employee=employeeRepo.save(employee);
		
		EmployeeResponse employeeResponse=modelMapper.map(employee, EmployeeResponse.class);
		return employeeResponse;		
	}

	
}
