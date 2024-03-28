package com.employee.management.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "department")
@Accessors(chain = true)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String address;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee manager;

    @OneToMany
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public List<Employee> getEmployees() {
        if (employees == null) {
            return new ArrayList<>();
        }
        return employees;
    }


}
