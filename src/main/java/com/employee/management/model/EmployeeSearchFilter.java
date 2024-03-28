package com.employee.management.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class EmployeeSearchFilter {

    private String firstName;
    private String lastName;
    private float minSalary;
    private float maxSalary;
    private String email;
    private Date createdDate;
    private String departmentName;
    private String company;

}
