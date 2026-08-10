package com.learning.employee_management_system.service;

import com.learning.employee_management_system.exceptions.EmployeeAlreadyExistException;
import com.learning.employee_management_system.exceptions.EmployeeNotFoundException;
import com.learning.employee_management_system.model.Employee;
import com.learning.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceDao {

	@org.springframework.beans.factory.annotation.Autowired
	private org.springframework.web.client.RestTemplate restTemplate;

	public String getEmployeeHistory(Long employeeId) {
		// Demonstrating RestTemplate communication to another microservice
		String url = "http://localhost:8082/api/history/" + employeeId;
		return restTemplate.getForObject(url, String.class);
	}


    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public Employee addEmployee(Employee employee) {

        Optional<Employee> existingEmployee = repository.findById(employee.getId());

        if (existingEmployee.isPresent()) {
            throw new EmployeeAlreadyExistException("Employee Already Exists");
        }

        return repository.save(employee); // direct save
    }


    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }


    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }


    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee oldEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        oldEmployee.setName(employee.getName());
        oldEmployee.setSalary(employee.getSalary());
        oldEmployee.setDepartment(employee.getDepartment());
        oldEmployee.setEmail(employee.getEmail());
        oldEmployee.setJoiningDate(employee.getJoiningDate());

        return repository.save(oldEmployee);
    }


    @Override
    public Employee partialUpdateEmployee(Long id, Map<String, Object> update) {

        Employee oldEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));

        if (update.containsKey("name")) {
            oldEmployee.setName(update.get("name").toString());
        }

        if (update.containsKey("salary")) {
            oldEmployee.setSalary(Double.parseDouble(update.get("salary").toString()));
        }

        if (update.containsKey("department")) {
            oldEmployee.setDepartment(update.get("department").toString());
        }

        if (update.containsKey("email")) {
            oldEmployee.setEmail(update.get("email").toString());
        }

        if (update.containsKey("joiningDate")) {
            oldEmployee.setJoiningDate(LocalDate.parse(update.get("joiningDate").toString()));
        }

        return repository.save(oldEmployee);
    }


    @Override
    public void deleteEmployee(Long id) {

        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }

        repository.deleteById(id);
    }
}
