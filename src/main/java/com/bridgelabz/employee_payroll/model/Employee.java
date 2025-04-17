package com.bridgelabz.employee_payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long employeeId;

    private String department;
    private String name;
    private long salary;

    public Employee(String department, String name, long salary) {
        this.department = department;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {

    }
}
