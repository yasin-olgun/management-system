package com.employee.management.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private float salary;
    private Long departmentId;
    private String departmentName;
    private String companyName;


}
