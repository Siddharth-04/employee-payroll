package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IEmployeeService {
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employee);
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id);
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id,@RequestBody EmployeeDTO employee);
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id);
}
