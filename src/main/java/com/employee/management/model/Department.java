package com.employee.management.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "department")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String address;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updated;

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
