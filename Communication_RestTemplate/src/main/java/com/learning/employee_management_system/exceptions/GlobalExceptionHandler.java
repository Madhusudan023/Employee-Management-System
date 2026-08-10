package com.learning.employee_management_system.exceptions;

import com.learning.employee_management_system.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    ResponseEntity<?> employeeHandlerNotFount(EmployeeNotFoundException ex){

        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()),  HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    ResponseEntity<?> employeeAlreadyExist(EmployeeAlreadyExistException ex){
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.CONFLICT);
    }
}
