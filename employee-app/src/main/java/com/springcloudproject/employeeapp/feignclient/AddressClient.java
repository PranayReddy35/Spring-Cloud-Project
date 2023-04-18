package com.springcloudproject.employeeapp.feignclient;

import com.springcloudproject.employeeapp.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "address-app",path = "/address-app/api/")
public interface AddressClient {
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> findAddressByEmployeeId(@PathVariable("employeeId") int id);

    @GetMapping("/address")
    public ResponseEntity<List<AddressResponse>> getAllAddress();
}
