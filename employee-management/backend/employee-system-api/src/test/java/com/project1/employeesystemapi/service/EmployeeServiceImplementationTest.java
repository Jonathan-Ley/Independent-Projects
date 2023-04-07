package com.project1.employeesystemapi.service;

import com.project1.employeesystemapi.entity.EmployeeEntity;
import com.project1.employeesystemapi.model.Employee;
import com.project1.employeesystemapi.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        employeeEntity.setId(1L);
        employeeEntity.setFirstName("John");
        employeeEntity.setLastName("Smith");
        employeeEntity.setEmail("test@test.org");
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity);
        Employee employee = new Employee(1L, "John", "Smith", "test@test.org");

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
        employeeEntity.setId(1L);
        employeeEntity.setFirstName("John");
        employeeEntity.setLastName("Ripper");
        employeeEntity.setEmail("test@test.org");
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
        employeeEntity.setId(1L);
        employeeEntity.setFirstName("John");
        employeeEntity.setLastName("Adams");
        employeeEntity.setEmail("test@test.org");
        Optional<EmployeeEntity> ofResult = Optional.of(employeeEntity);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        Employee actualEmployeeById = employeeServiceImplementation.getEmployeeById(1L);
        assertEquals(1L, actualEmployeeById.getId());
        assertEquals("John", actualEmployeeById.getFirstName());
        assertEquals("Adams", actualEmployeeById.getLastName());
        assertEquals("test@test.org", actualEmployeeById.getEmail());
        verify(employeeRepository).findById((Long) any());
    }

    @Test
    void testUpdateEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setLastName("Doe");
        Optional<EmployeeEntity> ofResult = Optional.of(employeeEntity);

        EmployeeEntity employeeEntity1 = new EmployeeEntity();
        employeeEntity1.setId(1L);
        employeeEntity1.setFirstName("Samual");
        employeeEntity1.setLastName("Adams");
        employeeEntity1.setEmail("test@test.org");
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity1);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        Employee employee = new Employee(1L, "Samual", "Adams", "test@test.org");

        assertSame(employee, employeeServiceImplementation.updateEmployee(1L, employee));
        verify(employeeRepository).save((EmployeeEntity) any());
        verify(employeeRepository).findById((Long) any());
    }
}

