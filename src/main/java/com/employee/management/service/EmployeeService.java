package com.employee.management.service;

import com.employee.management.dto.EmployeeDto;
import com.employee.management.mapper.EmployeeMapper;
import com.employee.management.model.Department;
import com.employee.management.model.Employee;
import com.employee.management.model.EmployeeSearchFilter;
import com.employee.management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    public ResponseEntity<String> addEmployee(EmployeeDto employeeDto) {

        Department department = departmentService.findById(employeeDto.getDepartment().getId());

        if (department == null) {
            log.info("EmployeeService -> addEmployee -> Department not found");

            return new ResponseEntity<>("Department not found", HttpStatus.NO_CONTENT);
        }

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(employee);
        log.info("EmployeeService -> addEmployee -> Employee saved successfully");

        return new ResponseEntity<>("Employee saved successfully", HttpStatus.OK);

    }

    public ResponseEntity<String> updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId()).orElse(null);
        Department department = departmentService.findById(employeeDto.getDepartment().getId());

        if (employee == null) {
            log.info("EmployeeService -> updateEmployee -> Employee not found");

            return new ResponseEntity<>("Employee not found", HttpStatus.NO_CONTENT);
        }

        if (department == null) {
            log.info("EmployeeService -> updateEmployee -> Department not found");
            return new ResponseEntity<>("Department not found", HttpStatus.NO_CONTENT);
        }
        employee = EmployeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(employee);
        log.info("EmployeeService -> updateEmployee -> Employee updated");

        return new ResponseEntity<>("Employee updated", HttpStatus.OK);

    }

    public ResponseEntity<Page<EmployeeDto>> searchEmployees(Pageable page, EmployeeSearchFilter employeeSearchFilter) {

        Specification<Employee> spec = Specification.where(null);

        if (employeeSearchFilter.getFirstName() != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("firstName"), employeeSearchFilter.getFirstName()));
        }
        if (employeeSearchFilter.getLastName() != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("lastName"), employeeSearchFilter.getLastName()));
        }
        if (employeeSearchFilter.getCreatedDate() != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("birthDate"), employeeSearchFilter.getCreatedDate()));
        }
        if (employeeSearchFilter.getMinSalary() > 0) {
            spec = spec.and((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("salary"), employeeSearchFilter.getMinSalary()));
        }
        if (employeeSearchFilter.getMaxSalary() > 0) {
            spec = spec.and((root, query, builder) -> builder.lessThanOrEqualTo(root.get("salary"), employeeSearchFilter.getMaxSalary()));
        }
        if (employeeSearchFilter.getDepartmentName() != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("department").get("name"), employeeSearchFilter.getDepartmentName()));
        }

        Page<Employee> employees = employeeRepository.findAll(spec, page);

        Page<EmployeeDto> employeeDtos = employees.map(EmployeeMapper::mapToEmployeeDto);
        log.info("EmployeeService -> searchEmployees -> searchEmployees completed");

        return new ResponseEntity<Page<EmployeeDto>>(employeeDtos, HttpStatus.OK);
    }

}
