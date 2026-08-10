package com.learning.employee_management_system.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEE-HISTORY-SERVICE", url = "http://localhost:8082")
public interface EmployeeHistoryClient {

    @GetMapping("/api/history/{id}")
    String getEmployeeHistory(@PathVariable("id") Long id);
}

