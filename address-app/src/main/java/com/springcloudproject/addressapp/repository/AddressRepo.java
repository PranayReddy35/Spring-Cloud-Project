package com.springcloudproject.addressapp.repository;

import com.springcloudproject.addressapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address, Integer> {
    @Query(nativeQuery = true, value = "SELECT ea.id, ea.lane1, ea.lane2, ea.state, ea.zip " +
            "FROM `Spring-Cloud-ProjectDB`.address ea " +
            "JOIN `Spring-Cloud-ProjectDB`.employee e ON e.id = ea.employee_Id " +
            "WHERE ea.employee_Id = :employeeId")
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);

//    @Modifying
//    @Query(nativeQuery = true, value = "UPDATE `Spring-Cloud-ProjectDB`.address ea " +
//            "JOIN `Spring-Cloud-ProjectDB`.employee e ON e.id = ea.employee_Id " +
//            "SET ea.lane1 = :lane1, ea.lane2 = :lane2, ea.state = :state, ea.zip = :zip " +
//            "WHERE ea.employee_Id = :employeeId")
//    Address updateAddressByEmployeeId(@Param("employeeId") int employeeId,
//                                      @Param("lane1") String lane1,
//                                      @Param("lane2") String lane2,
//                                      @Param("state") String state,
//                                      @Param("zip") String zip);
}



