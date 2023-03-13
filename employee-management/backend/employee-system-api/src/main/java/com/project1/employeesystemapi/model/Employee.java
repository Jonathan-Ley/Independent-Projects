package com.project1.employeesystemapi.model;

import lombok.Data;

@Data
public class Employee {
    private long id; //primary key
    private String firstName;
    private String lastName;
    private String emailId;
}
