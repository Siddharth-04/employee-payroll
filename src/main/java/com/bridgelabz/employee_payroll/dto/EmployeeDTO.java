package com.bridgelabz.employee_payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$",message = "Employee name invalid")
    private String name;

    @Min(value = 900,message = "Salary cannot be less than 900")
    private long salary;

    @Pattern(regexp = "male|female",message = "Gender needs to be male or female")
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start Date cannot be null")
    @PastOrPresent(message = "Start date should be past or todays date")
    private LocalDate startDate;

    @NotBlank(message = "Not cannot be empty")
    private String note;

    @NotBlank(message = "Profile pic cannot be empty")
    private String profilePic;

    @NotNull(message = "Department cannot be empty")
    private List<String> departments;
}
