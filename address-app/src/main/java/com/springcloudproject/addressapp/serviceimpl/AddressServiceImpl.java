package com.springcloudproject.addressapp.serviceimpl;

import com.springcloudproject.addressapp.entity.Address;
import com.springcloudproject.addressapp.repository.AddressRepo;
import com.springcloudproject.addressapp.response.AddressResponse;
import com.springcloudproject.addressapp.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressResponse getAddressByEmployeeId(int employeeId) {

        Address address = addressRepo.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
        return addressResponse;
    }

    @Override
    public AddressResponse addNewAddress(AddressResponse addressResponse) {

        Address address = modelMapper.map(addressResponse, Address.class);
        address = addressRepo.save(address);

        AddressResponse addressResponse1 = modelMapper.map(address, AddressResponse.class);
        return addressResponse1;
    }

    @Override
    public AddressResponse updateAddressByEmployeeId(AddressResponse addressResponse, int id) {

        Optional<Address> address = addressRepo.findById(id);

        if (address.isPresent()) {

            Address address1 = addressRepo.findById(id).get();

            address1.setLane1(addressResponse.getLane1());
            address1.setLane2(addressResponse.getLane2());
            address1.setState(addressResponse.getState());
            address1.setZip(addressResponse.getZip());

            address1 = addressRepo.save(address1);

            AddressResponse addressResponse1 = modelMapper.map(address1, AddressResponse.class);
            return addressResponse1;
        } else {

            Address address1 = modelMapper.map(addressResponse, Address.class);
            addressRepo.save(address1);

            AddressResponse addressResponse1 = modelMapper.map(address1, AddressResponse.class);
            return addressResponse1;
        }
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        List<Address> addresslist = addressRepo.findAll();
        List<AddressResponse> addressResponseList= new ArrayList<AddressResponse>();
        for(Address address:addresslist){
            AddressResponse addressResponse=new AddressResponse();
            addressResponse=modelMapper.map(address,AddressResponse.class);
            addressResponseList.add(addressResponse);
        }
        return addressResponseList;
    }
}

