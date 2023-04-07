package com.project1.employeesystemapi.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeEntityTest {

    @Test
    void testSetId() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        assertEquals(1L, employeeEntity.getId().longValue());
    }

    @Test
    void testGetId() {
        assertEquals(0L, (new EmployeeEntity()).getId().longValue());
    }
}

