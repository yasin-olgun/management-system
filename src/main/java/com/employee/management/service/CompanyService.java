package com.employee.management.service;

import com.employee.management.model.Company;
import com.employee.management.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;

    public ResponseEntity<List<Company>> list() {
        List<Company> companies = companyRepository.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }


    public ResponseEntity<Page<Company>> listPage(int page, int size) {

        Page<Company> companies = companyRepository.findAll(PageRequest.of(page, size));
        log.info("CompanyService -> listPage -> Companies listed!");
        return new ResponseEntity<Page<Company>>(companies, HttpStatus.OK);
    }

    public ResponseEntity<Company> findById(long id) {
        Company company = companyRepository.findById(id).orElse(null);
        log.info("CompanyService -> findyById -> Company find by id");

        return new ResponseEntity<>(company, HttpStatus.OK);
    }


    public ResponseEntity<String> addCompany(Company company) {
        companyRepository.save(company);
        log.info("CompanyService -> addCompany -> Saved!");
        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

}
