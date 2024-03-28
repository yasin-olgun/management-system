package com.employee.management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "company")
@Accessors(chain = true)

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updated;

    private String name;

    private Country country;

    @OneToMany
    private List<Department> departmentList;

    public List<Department> getDepartmentList() {
        if (departmentList == null) {
            return new ArrayList<>();
        }
        return departmentList;
    }
}
