package com.learning.employee_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	@org.springframework.context.annotation.Bean
	public org.springframework.web.reactive.function.client.WebClient.Builder webClientBuilder() {
		return org.springframework.web.reactive.function.client.WebClient.builder();
	}


	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

}

