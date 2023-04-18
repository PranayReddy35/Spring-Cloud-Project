package com.springcloudproject.addressapp.service;

import com.springcloudproject.addressapp.response.AddressResponse;

import java.util.List;

public interface AddressService {
    AddressResponse getAddressByEmployeeId(int employeeId);


    AddressResponse addNewAddress(AddressResponse addressResponse);

    AddressResponse updateAddressByEmployeeId(AddressResponse addressResponse, int id);

    List<AddressResponse> getAllAddress();
}
