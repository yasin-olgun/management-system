package com.employee.management.controller;

import com.employee.management.model.Company;
import com.employee.management.model.Department;
import com.employee.management.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping("page")
    public ResponseEntity<Page<Company>> listPaging(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                    @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return companyService.listPage(page, size);
    }

    @GetMapping("id")
    public ResponseEntity<Company> getById(@RequestParam(value = "id", required = true) long id) {
        return companyService.findById(id);
    }

    @GetMapping("hello")
    public ResponseEntity<String> helloToEveryOne(@RequestParam(value = "text") String text) {
        return new ResponseEntity<>(text, HttpStatus.OK);
    }


}
