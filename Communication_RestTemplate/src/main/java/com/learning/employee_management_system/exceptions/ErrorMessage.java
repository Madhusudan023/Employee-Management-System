package com.learning.employee_management_system.exceptions;

import org.springframework.http.HttpStatusCode;

public class ErrorMessage  {
    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
