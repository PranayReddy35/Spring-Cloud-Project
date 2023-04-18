package com.springcloudproject.employeeapp.serviceimpl;

import com.springcloudproject.employeeapp.entity.Employee;
import com.springcloudproject.employeeapp.feignclient.AddressClient;
import com.springcloudproject.employeeapp.repository.EmployeeRepo;
import com.springcloudproject.employeeapp.response.AddressResponse;
import com.springcloudproject.employeeapp.response.EmployeeResponse;
import com.springcloudproject.employeeapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressClient addressClient;

    @Override
    public EmployeeResponse getEmployeeById(int id) {

        Employee employee = employeeRepo.findById(id).get();

        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        ResponseEntity<AddressResponse> addressResponseEntity = addressClient.findAddressByEmployeeId(id);
        AddressResponse addressResponse = addressResponseEntity.getBody();

        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeResponse empResponse) {
        Employee employee = modelMapper.map(empResponse, Employee.class);
        employee = employeeRepo.save(employee);

        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        return employeeResponse;
    }

}
