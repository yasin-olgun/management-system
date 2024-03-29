package com.employee.management.mapper;

import com.employee.management.dto.DepartmentDto;
import com.employee.management.model.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto()
                .setId(department.getId())
                .setName(department.getName());
    }

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department()
                .setId(departmentDto.getId())
                .setName(departmentDto.getName());
    }


}
