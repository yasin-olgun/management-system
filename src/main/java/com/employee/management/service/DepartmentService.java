package com.employee.management.service;

import com.employee.management.dto.DepartmentDto;
import com.employee.management.dto.EmployeeDto;
import com.employee.management.mapper.DepartmentMapper;
import com.employee.management.mapper.EmployeeMapper;
import com.employee.management.model.Department;
import com.employee.management.model.Employee;
import com.employee.management.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentDto findByIdDto(Long id) {
        return DepartmentMapper.mapToDempartmentDto(Objects.requireNonNull(departmentRepository.findById(id).orElse(null)));
    }

    public ResponseEntity<String> addDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDempartment(departmentDto);
        departmentRepository.save(department);
        return new ResponseEntity<>("Department saved successfully", HttpStatus.OK);
    }

}
