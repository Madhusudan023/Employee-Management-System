# Employee Management System (RestTemplate Communication)

## 🏢 What is this?
This is the Employee Management System microservice. In addition to handling basic CRUD operations for employees, it demonstrates how to communicate with other microservices (like the Employee History service) using **RestTemplate**.

## 🏗️ Architecture & How We Made It
- **Spring Boot**: Foundation of the application.
- **RestTemplate**: We defined a `RestTemplate` bean in the main application class (`EmployeeManagementSystemApplication.java`). 
- **Service Layer Integration**: In `EmployeeService.java`, we auto-wired the `RestTemplate` and used its `getForObject()` method to make a synchronous HTTP GET request to `http://localhost:8082/api/history/{id}`.

## 💡 Why We Made It?
Microservices cannot exist in isolation; they must communicate. 
- **RestTemplate** is the traditional, synchronous Spring HTTP client. It is easy to use and understand for blocking operations.
- While Spring has deprecated it in favor of WebClient for new projects, it is crucial to understand how it works as many legacy systems and current tutorials still use it. It is perfectly fine for simple, non-reactive architectures.
