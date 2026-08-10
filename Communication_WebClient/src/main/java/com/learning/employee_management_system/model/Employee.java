package com.learning.employee_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
@Table(name="employee_table")
public class Employee {
    @Id
    private Long id;
    private String name;
    private String email;
    private String department;
    private double salary;
    private LocalDate joiningDate;
}
