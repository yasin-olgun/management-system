package com.employee.management.mapper;

import com.employee.management.dto.EmployeeDto;
import com.employee.management.model.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto()
                .setId(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setSalary(employee.getSalary())
                .setEmail(employee.getEmail())
                .setDepartment(employee.getDepartment())
                .setCompanyName(employee.getDepartment().getCompany().getName());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee()
                .setId(employeeDto.getId())
                .setEmail(employeeDto.getEmail())
                .setFirstName(employeeDto.getFirstName())
                .setSalary(employeeDto.getSalary())
                .setLastName(employeeDto.getLastName())
                .setDepartment(employeeDto.getDepartment());
    }
}
