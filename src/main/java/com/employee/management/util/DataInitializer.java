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
import java.util.Random;

@RequiredArgsConstructor
@Component
public class DataInitializer {


    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;


    @PostConstruct
    public void initData() {

        if (companyRepository.findAll().isEmpty()) {
          initRandomData();
        }


    }

    public int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private String generateRandomString() {
        int n = 10;
        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    private void initRandomData() {
        Company company = new Company()
                .setCountry(Country.TURKIYE)
                .setName("GOOGLE");
        companyRepository.save(company);
        Department department = new Department();
        Employee employee = new Employee();

        for (int i = 0; i < 5; i++) {
            department.setName(generateRandomString())
                    .setAddress("ANKARA")
                    .setCompany(company);

            departmentRepository.save(department);
            for (int j = 0; j < 10; j++) {
                employee.setFirstName(generateRandomString())
                        .setLastName(generateRandomString())
                        .setSalary(generateRandomNumber(10000, 100000))
                        .setEmail(generateRandomString() + "@" + generateRandomString() + ".com")
                        .setDepartment(department);
                employeeRepository.save(employee);
            }
        }
    }


}
