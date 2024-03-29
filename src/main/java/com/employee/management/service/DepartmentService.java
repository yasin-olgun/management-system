package com.employee.management.service;

import com.employee.management.dto.DepartmentDto;
import com.employee.management.mapper.DepartmentMapper;
import com.employee.management.model.Department;
import com.employee.management.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentDto findByIdDto(Long id) {
        log.info("DepartmentService -> findByIdDto -> Department find by id");
        return DepartmentMapper.mapToDepartmentDto(Objects.requireNonNull(departmentRepository.findById(id).orElse(null)));
    }

    public ResponseEntity<String> addDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        departmentRepository.save(department);
        log.info("DepartmentService -> addDepartment -> Department add completed");

        return new ResponseEntity<>("Department saved successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> addManager(DepartmentDto departmentDto) {

        Department department = departmentRepository.findById(departmentDto.getId()).orElse(null);
        if (department == null) {
            return new ResponseEntity<>("Department not found", HttpStatus.NO_CONTENT);
        }
        department.setManager(departmentDto.getManager());
        departmentRepository.save(department);
        return new ResponseEntity<>("Department manager updated", HttpStatus.OK);

    }

}
