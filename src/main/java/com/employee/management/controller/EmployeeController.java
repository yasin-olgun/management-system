package com.employee.management.controller;

import com.employee.management.dto.EmployeeDto;
import com.employee.management.model.EmployeeSearchFilter;
import com.employee.management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @PostMapping("update")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto);
    }

    @GetMapping("search")
    public ResponseEntity<Page<EmployeeDto>> searchEmployee(@RequestBody EmployeeSearchFilter employeeSearchFilter, @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return employeeService.searchEmployees(PageRequest.of(page, size), employeeSearchFilter);
    }


}
