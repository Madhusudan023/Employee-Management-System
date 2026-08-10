package com.learning.employee_management_system.service;
import com.learning.employee_management_system.model.Employee;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeServiceDao {

    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    Employee partialUpdateEmployee(Long id, Map<String, Object> update);
    void deleteEmployee(Long id);

}
