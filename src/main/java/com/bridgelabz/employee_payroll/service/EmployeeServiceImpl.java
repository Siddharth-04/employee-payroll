package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.model.Employee;
import com.bridgelabz.employee_payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeDTO employee) {
        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setDepartment(employee.getDepartment());
        newEmployee.setSalary(employee.getSalary());

        if(newEmployee.getName() != null && (newEmployee.getSalary() != 0)){
            employeeRepository.save(newEmployee);
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(newEmployee, HttpStatus.BAD_REQUEST);
    }
}
