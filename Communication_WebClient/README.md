# Employee Management System (WebClient Communication)

## 🏢 What is this?
This is the Employee Management System microservice. It handles CRUD operations for employees and demonstrates inter-service communication using **Spring WebClient**, the modern, reactive, non-blocking HTTP client.

## 🏗️ Architecture & How We Made It
- **Spring Boot & WebFlux**: We added the `spring-boot-starter-webflux` dependency to `pom.xml`.
- **WebClient Bean**: We defined a `WebClient.Builder` bean in `EmployeeManagementSystemApplication.java`.
- **Service Layer Integration**: In `EmployeeService.java`, we used the `WebClient` to make HTTP requests to `http://localhost:8082/api/history/{id}`. We used `.retrieve().bodyToMono().block()` to synchronously wait for the response (though in a fully reactive system, we would return the `Mono` directly).

## 💡 Why We Made It?
- **Modern Alternative**: WebClient is Spring's recommended HTTP client moving forward, replacing `RestTemplate`.
- **Performance**: It uses a non-blocking, reactive underlying engine (Project Reactor and Netty). This means it can handle thousands of concurrent requests with a very small number of threads, drastically reducing memory footprint and improving scalability under heavy load compared to the blocking `RestTemplate`.
