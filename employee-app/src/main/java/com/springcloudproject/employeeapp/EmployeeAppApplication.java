package com.springcloudproject.employeeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//Use below reference to scan feign client if it is in a different package than root package.
//@EnableFeignClients(basePackages = "com.springcloudproject.employeeapp.feignclient")
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
	}
}
