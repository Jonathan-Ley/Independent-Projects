package com.project1.employeesystemapi.entity;
//where I want to save the data from db; work w/ JPA to save data

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //primary key
    private String firstName;
    private String lastName;
    private String emailId;
}
