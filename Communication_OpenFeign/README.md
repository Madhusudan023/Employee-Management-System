# Employee Management System (OpenFeign Communication)

## 🏢 What is this?
This version of the Employee Management System demonstrates inter-service communication using **Spring Cloud OpenFeign**, a declarative REST client.

## 🏗️ Architecture & How We Made It
- **Dependency**: Added `spring-cloud-starter-openfeign` to `pom.xml`.
- **Enable Feign**: Annotated `EmployeeManagementSystemApplication.java` with `@EnableFeignClients`.
- **Declarative Client Interface**: We created `EmployeeHistoryClient.java` and annotated it with `@FeignClient(name = "EMPLOYEE-HISTORY-SERVICE", url = "http://localhost:8082")`. We then defined the HTTP methods (`@GetMapping`) just like we would in a Spring MVC Controller.
- **Service Layer**: In `EmployeeService.java`, we simply auto-wired the `EmployeeHistoryClient` interface and called its methods. Spring Cloud automatically generated the implementation at runtime.

## 💡 Why We Made It?
- **Readability & Maintainability**: OpenFeign eliminates the boilerplate code associated with `RestTemplate` and `WebClient`. You don't have to write code to construct URLs, set headers, or map responses. You just write an interface.
- **Integration**: It integrates seamlessly with Eureka (Service Discovery) and Resilience4j (Circuit Breakers). If we remove the `url` parameter from `@FeignClient`, Feign will automatically ask Eureka for the IP address of `EMPLOYEE-HISTORY-SERVICE` and load balance across available instances.
