package com.project1.employeesystemapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.project1.employeesystemapi.entity.EmployeeEntity;
import com.project1.employeesystemapi.model.Employee;
import com.project1.employeesystemapi.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceImplementationTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceImplementation employeeServiceImplementation;

    @Test
    void testCreateEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity);
        Employee employee = new Employee(1L, "Jane", "Doe", "jane.doe@example.org");

        assertSame(employee, employeeServiceImplementation.createEmployee(employee));
        verify(employeeRepository).save((EmployeeEntity) any());
    }

    @Test
    void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(employeeServiceImplementation.getAllEmployees().isEmpty());
        verify(employeeRepository).findAll();
    }

    @Test
    void testDeleteEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");
        Optional<EmployeeEntity> ofResult = Optional.of(employeeEntity);
        doNothing().when(employeeRepository).delete((EmployeeEntity) any());
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        assertTrue(employeeServiceImplementation.deleteEmployee(1L));
        verify(employeeRepository).findById((Long) any());
        verify(employeeRepository).delete((EmployeeEntity) any());
    }

    @Test
    void testGetEmployeeById() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");
        Optional<EmployeeEntity> ofResult = Optional.of(employeeEntity);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        Employee actualEmployeeById = employeeServiceImplementation.getEmployeeById(1L);
        assertEquals("jane.doe@example.org", actualEmployeeById.getEmail());
        assertEquals("Doe", actualEmployeeById.getLastName());
        assertEquals(1L, actualEmployeeById.getId());
        assertEquals("Jane", actualEmployeeById.getFirstName());
        verify(employeeRepository).findById((Long) any());
    }

    @Test
    void testUpdateEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");
        Optional<EmployeeEntity> ofResult = Optional.of(employeeEntity);

        EmployeeEntity employeeEntity1 = new EmployeeEntity();
        employeeEntity1.setEmail("jane.doe@example.org");
        employeeEntity1.setFirstName("Jane");
        employeeEntity1.setId(1L);
        employeeEntity1.setLastName("Doe");
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity1);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        Employee employee = new Employee(1L, "Jane", "Doe", "jane.doe@example.org");

        assertSame(employee, employeeServiceImplementation.updateEmployee(1L, employee));
        verify(employeeRepository).save((EmployeeEntity) any());
        verify(employeeRepository).findById((Long) any());
    }
}

