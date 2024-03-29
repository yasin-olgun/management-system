package com.employee.management.controller;

import com.employee.management.dto.DepartmentDto;
import com.employee.management.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<DepartmentDto> getById(@RequestParam(value = "id", required = true) long id) {
        DepartmentDto department = departmentService.findByIdDto(id);
        if (department == null) {
            return new ResponseEntity<>((DepartmentDto) null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }

}
