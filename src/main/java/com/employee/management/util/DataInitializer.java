package com.employee.management.util;

import com.employee.management.model.Company;
import com.employee.management.model.Country;
import com.employee.management.model.Department;
import com.employee.management.model.Employee;
import com.employee.management.repository.CompanyRepository;
import com.employee.management.repository.DepartmentRepository;
import com.employee.management.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer {


    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;


    @PostConstruct
    public void initData() {

        if (companyRepository.findAll().isEmpty()) {
            addCompany();
        }

        if (departmentRepository.findAll().isEmpty()) {
            addDepartment();
        }

        if (employeeRepository.findAll().isEmpty()) {
            addEmployee();
        }


    }

    private void addCompany() {
        Company company = new Company()
                .setCountry(Country.TURKIYE)
                .setName("GOOGLE");

        companyRepository.save(company);
    }

    private void addDepartment() {
        Company company = companyRepository.findByName("GOOGLE");
        Department department = new Department()
                .setName("IT")
                .setAddress("ANKARA")
                .setCompany(company);

        Department department2 = new Department()
                .setName("HR")
                .setAddress("ANKARA")
                .setCompany(company);

        Department department3 = new Department()
                .setName("FINANCE")
                .setAddress("ANKARA")
                .setCompany(company);

        departmentRepository.save(department);
        departmentRepository.save(department2);
        departmentRepository.save(department3);
    }

    private void addEmployee() {


        Employee employee = new Employee()
                .setFirstName("Morgan")
                .setLastName("Wallace")
                .setSalary(50000)
                .setEmail("morgan@morgan.com")
                .setDepartment(departmentRepository.findByName("IT"));
        employeeRepository.save(employee);

        Employee employee2 = new Employee()
                .setFirstName("Lucille")
                .setLastName("Levy")
                .setSalary(70000)
                .setEmail("lucille@temp.com")
                .setDepartment(departmentRepository.findByName("HR"));
        employeeRepository.save(employee2);

        Employee employee3 = new Employee()
                .setFirstName("John")
                .setLastName("Hickman")
                .setSalary(20000)
                .setEmail("john@john.com")
                .setDepartment(departmentRepository.findByName("FINANCE"));
        employeeRepository.save(employee3);

        Employee employee4 = new Employee()
                .setFirstName("Harry")
                .setLastName("Potter")
                .setSalary(60000)
                .setEmail("harry@potter.com")
                .setDepartment(departmentRepository.findByName("IT"));
        employeeRepository.save(employee4);

    }


}
