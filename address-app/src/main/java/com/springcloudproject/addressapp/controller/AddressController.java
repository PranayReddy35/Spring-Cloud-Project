package com.springcloudproject.addressapp.controller;

import com.springcloudproject.addressapp.response.AddressResponse;
import com.springcloudproject.addressapp.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<AddressResponse>> getAllAddress() {
        List<AddressResponse> addressReponse = addressService.getAllAddress();
        return ResponseEntity.status(HttpStatus.OK).body(addressReponse);
    }
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> findAddressByEmployeeId(@PathVariable("employeeId") int id) {
        log.info("Getting address with id : {}", id);
        AddressResponse addressResponse = addressService.getAddressByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @PostMapping("/address")
    public ResponseEntity<AddressResponse> addNewAddress(@RequestBody AddressResponse addressResponse) {
        log.info("Creating a new address with details : {}", addressResponse);
        AddressResponse addressResponse1 = addressService.addNewAddress(addressResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse1);
    }

    @PutMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> updateAddressByEmployeeId(@RequestBody AddressResponse addressResponse,
                                                                     @PathVariable("employeeId") int id) {
        log.info("Updating the address with Employee ID : {}", id + " with details : {}", addressResponse);
        AddressResponse addressResponse1 = addressService.updateAddressByEmployeeId(addressResponse, id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse1);
    }
}
