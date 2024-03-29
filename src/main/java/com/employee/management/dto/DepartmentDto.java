package com.employee.management.dto;

import com.employee.management.model.Employee;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DepartmentDto {

    private Long id;
    private String name;
    private Employee manager;

}
