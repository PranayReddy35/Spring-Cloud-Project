package com.springcloudproject.employeeapp.serviceimpl;

import com.springcloudproject.employeeapp.entity.Employee;
import com.springcloudproject.employeeapp.repository.EmployeeRepo;
import com.springcloudproject.employeeapp.response.AddressResponse;
import com.springcloudproject.employeeapp.response.EmployeeResponse;
import com.springcloudproject.employeeapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WebClient webClient;

//    private final RestTemplate restTemplate;
//    @Value("${address-app.base.url}")
//    private String addressBaseUrl;

//    public EmployeeServiceImpl(@Value("${address-app.base.url}") String addressBaseUrl, RestTemplateBuilder builder) {
//        log.info("uri : " + addressBaseUrl);
//        this.restTemplate = builder.rootUri(addressBaseUrl).build();
//    }

    @Override
    public EmployeeResponse getEmployeeById(int id) {

        Employee employee = employeeRepo.findById(id).get();

        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        AddressResponse addressResponse = webClient.get()
                .uri("/address/" + id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();

        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

//    private AddressResponse callingAddressServiceUsingRESTTemplate(int id) {
//        return restTemplate.getForObject("/address/{id}"
//                , AddressResponse.class, id);
//    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeResponse empResponse) {
        Employee employee = modelMapper.map(empResponse, Employee.class);
        employee = employeeRepo.save(employee);

        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        return employeeResponse;
    }

}
