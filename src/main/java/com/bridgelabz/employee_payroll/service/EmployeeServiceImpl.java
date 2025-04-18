package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDTO;
import com.bridgelabz.employee_payroll.model.Employee;
import com.bridgelabz.employee_payroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeDTO employee) {
        Employee newEmployee = new Employee(employee);
        employeeRepository.save(newEmployee);
        log.info("Employee created with id: {}", newEmployee.getEmployeeId());
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Long id) {
        Optional<Employee> obj = employeeRepository.findById(id);

        if(obj.isPresent()){
            Employee emp = obj.get();
            log.info("Employee found with id: {}", emp.getEmployeeId());
            return new ResponseEntity<>(emp,HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseDTO updateEmployeeById(Long id, EmployeeDTO employee) {
        Optional<Employee> obj= employeeRepository.findById(id);

        if(obj.isPresent()){
            Employee em = obj.get();

            if (employee.getName() != null) em.setName(employee.getName());
            if (employee.getSalary() != 0) em.setSalary(employee.getSalary());
            if (employee.getDepartments() != null) em.setDepartments(employee.getDepartments());
            if (employee.getGender() != null) em.setGender(employee.getGender());
            if (employee.getNote() != null) em.setNote(employee.getNote());
            if (employee.getProfilePic() != null) em.setProfilePic(employee.getProfilePic());
            if (employee.getStartDate() != null) em.setStartDate(employee.getStartDate());
            log.info("Employee updated with id: {}", em.getEmployeeId());
            employeeRepository.save(em);
            return new ResponseDTO("User details updated",HttpStatus.OK);
        }

        log.error("Employee not found with id: {}", id);
        return new ResponseDTO("User not found with this ID",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteEmployeeById(Long id) {
        Optional<Employee> obj = employeeRepository.findById(id);

        if(obj.isPresent()){
            log.info("Employee deleted with id: {}", id);
            employeeRepository.deleteById(id);
            return new ResponseEntity<>("User deleted with id "+id,HttpStatus.NO_CONTENT);
        }

        log.error("Employee not found : {}", id);
        return new ResponseEntity<>("User not found with id "+id,HttpStatus.NOT_FOUND);
    }


}
