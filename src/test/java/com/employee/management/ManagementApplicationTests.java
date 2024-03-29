package com.employee.management;

import com.employee.management.model.Company;
import com.employee.management.model.Country;
import com.employee.management.model.Department;
import com.employee.management.model.Employee;
import com.employee.management.repository.CompanyRepository;
import com.employee.management.repository.DepartmentRepository;
import com.employee.management.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManagementApplicationTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void editEmployee() {
        //Update employee department
        Employee employee = employeeRepository.findByFirstName("Harry");
        Department department = departmentRepository.findByName("FINANCE");

        employee.setDepartment(department)
                .setSalary(1500);
        employeeRepository.save(employee);
    }

    @Test
    public void addEmployee() {
        //Update employee department
        Department department = departmentRepository.findByName("IT");
        Employee employee = new Employee()
                .setFirstName("TEST employee")
                .setEmail("testemp@test.com")
                .setDepartment(department)
                .setSalary(10);
        employeeRepository.save(employee);
    }

    @Test
    public void addCompany() {
        Company company = new Company()
                .setName("MICROSOFT")
                .setCountry(Country.USA);

        Department department = new Department()
                .setCompany(company)
                .setName("Test")
                .setAddress("ISTANBUL");


        companyRepository.save(company);
        departmentRepository.save(department);
    }


}
