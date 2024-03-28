package com.employee.management.mapper;

import com.employee.management.dto.DepartmentDto;
import com.employee.management.dto.EmployeeDto;
import com.employee.management.model.Department;
import com.employee.management.model.Employee;

public class DepartmentMapper {

    public static DepartmentDto mapToDempartmentDto(Department department) {
        return new DepartmentDto()
                .setId(department.getId())
                .setName(department.getName());
    }

    public static Department mapToDempartment(DepartmentDto departmentDto) {
        return new Department()
                .setId(departmentDto.getId())
                .setName(departmentDto.getName());
    }


}
