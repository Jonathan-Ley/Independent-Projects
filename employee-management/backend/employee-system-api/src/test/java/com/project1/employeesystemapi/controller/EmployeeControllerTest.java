package com.project1.employeesystemapi.controller;

import com.project1.employeesystemapi.entity.EmployeeEntity;
import com.project1.employeesystemapi.model.Employee;
import com.project1.employeesystemapi.repository.EmployeeRepository;
import com.project1.employeesystemapi.service.EmployeeServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Test
    void testCreateEmployee() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        employeeEntity.setFirstName("Test");
        employeeEntity.setLastName("Testing");
        employeeEntity.setEmail("test@test.org");
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity);
        EmployeeController employeeController = new EmployeeController(
                new EmployeeServiceImplementation(employeeRepository));
        Employee employee = new Employee(1L, "Test", "Testing", "test@test.org");

        assertSame(employee, employeeController.createEmployee(employee));
        verify(employeeRepository).save((EmployeeEntity) any());
    }

    @Test
    void testGetAllEmployees() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(
                (new EmployeeController(new EmployeeServiceImplementation(employeeRepository))).getAllEmployees().isEmpty());
        verify(employeeRepository).findAll();
    }

    @Test
    void testDeleteEmployee() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        employeeEntity.setFirstName("Test");
        employeeEntity.setLastName("Test");
        employeeEntity.setEmail("test@test.org");
        Optional<EmployeeEntity> ofResult = Optional.of(employeeEntity);
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        doNothing().when(employeeRepository).delete((EmployeeEntity) any());
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        ResponseEntity<Map<String, Boolean>> actualDeleteEmployeeResult = (new EmployeeController(
                new EmployeeServiceImplementation(employeeRepository))).deleteEmployee(1L);
        assertEquals(1, actualDeleteEmployeeResult.getBody().size());
        assertTrue(actualDeleteEmployeeResult.hasBody());
        assertEquals(200, actualDeleteEmployeeResult.getStatusCodeValue());
        assertTrue(actualDeleteEmployeeResult.getHeaders().isEmpty());
        verify(employeeRepository).findById((Long) any());
        verify(employeeRepository).delete((EmployeeEntity) any());
    }

    @Test
    void testGetEmployeeById() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        employeeEntity.setFirstName("Test");
        employeeEntity.setLastName("Testing");
        employeeEntity.setEmail("test@test.org");
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findById((Long) any())).thenReturn(Optional.of(employeeEntity));
        ResponseEntity<Employee> actualEmployeeById = (new EmployeeController(
                new EmployeeServiceImplementation(employeeRepository))).getEmployeeById(1L);
        assertTrue(actualEmployeeById.hasBody());
        assertTrue(actualEmployeeById.getHeaders().isEmpty());
        assertEquals(200, actualEmployeeById.getStatusCodeValue());
        Employee body = actualEmployeeById.getBody();
        assertEquals(1L, body.getId());
        assertEquals("Test", body.getFirstName());
        assertEquals("Testing", body.getLastName());
        assertEquals("test@test.org", body.getEmail());
        verify(employeeRepository).findById((Long) any());
    }

    @Test
    void testUpdateEmployee() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        employeeEntity.setFirstName("Test");
        employeeEntity.setLastName("Testing");
        employeeEntity.setEmail("test@test.org");
        Optional<EmployeeEntity> ofResult = Optional.of(employeeEntity);

        EmployeeEntity employeeEntity1 = new EmployeeEntity();
        employeeEntity1.setId(1L);
        employeeEntity1.setFirstName("John");
        employeeEntity1.setLastName("Ripper");
        employeeEntity1.setEmail("ripper@test.org");
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity1);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        EmployeeController employeeController = new EmployeeController(
                new EmployeeServiceImplementation(employeeRepository));
        ResponseEntity<Employee> actualUpdateEmployeeResult = employeeController.updateEmployee(1L,
                new Employee(1L, "John", "Ripper", "ripper@test.org"));
        assertTrue(actualUpdateEmployeeResult.hasBody());
        assertTrue(actualUpdateEmployeeResult.getHeaders().isEmpty());
        assertEquals(200, actualUpdateEmployeeResult.getStatusCodeValue());
        verify(employeeRepository).save((EmployeeEntity) any());
        verify(employeeRepository).findById((Long) any());
    }
}

