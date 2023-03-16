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
    @Disabled("TODO: Complete this test")
    void testCreateEmployee2() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity);
        employeeServiceImplementation.createEmployee(null);
    }

    @Test
    void testCreateEmployee3() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity);
        Employee employee = mock(Employee.class);
        when(employee.getEmail()).thenReturn("jane.doe@example.org");
        when(employee.getFirstName()).thenReturn("Jane");
        when(employee.getLastName()).thenReturn("Doe");
        when(employee.getId()).thenReturn(1L);
        employeeServiceImplementation.createEmployee(employee);
        verify(employeeRepository).save((EmployeeEntity) any());
        verify(employee).getEmail();
        verify(employee).getFirstName();
        verify(employee).getLastName();
        verify(employee).getId();
    }

    @Test
    void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(employeeServiceImplementation.getAllEmployees().isEmpty());
        verify(employeeRepository).findAll();
    }

    @Test
    void testGetAllEmployees2() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");

        ArrayList<EmployeeEntity> employeeEntityList = new ArrayList<>();
        employeeEntityList.add(employeeEntity);
        when(employeeRepository.findAll()).thenReturn(employeeEntityList);
        List<Employee> actualAllEmployees = employeeServiceImplementation.getAllEmployees();
        assertEquals(1, actualAllEmployees.size());
        Employee getResult = actualAllEmployees.get(0);
        assertEquals("jane.doe@example.org", getResult.getEmail());
        assertEquals("Doe", getResult.getLastName());
        assertEquals(1L, getResult.getId());
        assertEquals("Jane", getResult.getFirstName());
        verify(employeeRepository).findAll();
    }

    @Test
    void testGetAllEmployees3() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");

        EmployeeEntity employeeEntity1 = new EmployeeEntity();
        employeeEntity1.setEmail("john.smith@example.org");
        employeeEntity1.setFirstName("John");
        employeeEntity1.setId(2L);
        employeeEntity1.setLastName("Smith");

        ArrayList<EmployeeEntity> employeeEntityList = new ArrayList<>();
        employeeEntityList.add(employeeEntity1);
        employeeEntityList.add(employeeEntity);
        when(employeeRepository.findAll()).thenReturn(employeeEntityList);
        List<Employee> actualAllEmployees = employeeServiceImplementation.getAllEmployees();
        assertEquals(2, actualAllEmployees.size());
        Employee getResult = actualAllEmployees.get(0);
        assertEquals("Smith", getResult.getLastName());
        Employee getResult1 = actualAllEmployees.get(1);
        assertEquals("Doe", getResult1.getLastName());
        assertEquals(1L, getResult1.getId());
        assertEquals("Jane", getResult1.getFirstName());
        assertEquals("jane.doe@example.org", getResult1.getEmail());
        assertEquals(2L, getResult.getId());
        assertEquals("John", getResult.getFirstName());
        assertEquals("john.smith@example.org", getResult.getEmail());
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
    @Disabled("TODO: Complete this test")
    void testDeleteEmployee2() {

        doNothing().when(employeeRepository).delete((EmployeeEntity) any());
        when(employeeRepository.findById((Long) any())).thenReturn(Optional.empty());
        employeeServiceImplementation.deleteEmployee(1L);
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
    @Disabled("TODO: Complete this test")
    void testGetEmployeeById2() {

        when(employeeRepository.findById((Long) any())).thenReturn(Optional.empty());
        employeeServiceImplementation.getEmployeeById(1L);
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

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateEmployee2() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("jane.doe@example.org");
        employeeEntity.setFirstName("Jane");
        employeeEntity.setId(1L);
        employeeEntity.setLastName("Doe");
        when(employeeRepository.save((EmployeeEntity) any())).thenReturn(employeeEntity);
        when(employeeRepository.findById((Long) any())).thenReturn(Optional.empty());
        employeeServiceImplementation.updateEmployee(1L, new Employee(1L, "Jane", "Doe", "jane.doe@example.org"));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateEmployee3() {

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
        employeeServiceImplementation.updateEmployee(1L, null);
    }

    @Test
    void testUpdateEmployee4() {
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
        Employee employee = mock(Employee.class);
        when(employee.getEmail()).thenReturn("jane.doe@example.org");
        when(employee.getFirstName()).thenReturn("Jane");
        when(employee.getLastName()).thenReturn("Doe");
        employeeServiceImplementation.updateEmployee(1L, employee);
        verify(employeeRepository).save((EmployeeEntity) any());
        verify(employeeRepository).findById((Long) any());
        verify(employee).getEmail();
        verify(employee).getFirstName();
        verify(employee).getLastName();
    }
}

