package com.employee.management.mapper;

import com.employee.management.dto.DepartmentDto;
import com.employee.management.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper2 {
    DepartmentMapper2 INSTANCE = Mappers.getMapper(DepartmentMapper2.class);

    @Mapping(target = "id", ignore = true)
    Department toDepartment(DepartmentDto departmentDto);

    DepartmentDto toDepartmentDto(Department department);

}
