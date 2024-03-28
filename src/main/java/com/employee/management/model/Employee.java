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
@Accessors(chain = true)
@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private float salary;
    private Date birthDate;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
