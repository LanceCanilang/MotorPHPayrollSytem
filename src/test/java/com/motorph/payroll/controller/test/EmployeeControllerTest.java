package com.motorph.payroll.controller.test;

import com.motorph.payroll.controller.EmployeeController;
import com.motorph.payroll.model.Employee;
import com.motorph.payroll.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    private EmployeeController employeeController;

    @BeforeEach
    public void setUp() {
        employeeController = new EmployeeController(employeeService);
    }

    /**
     * Simple helper to create a mock Employee (Employee is abstract now).
     * This keeps your tests minimal and focused on controller-service behavior.
     */
    private Employee mockEmployee(int id, String lastName, String firstName) {
        Employee e = mock(Employee.class);
        when(e.getEmployeeId()).thenReturn(id);
        when(e.getLastName()).thenReturn(lastName);
        when(e.getFirstName()).thenReturn(firstName);
        when(e.getStatus()).thenReturn("Regular");
        return e;
    }

    @Test
    public void testGetAllEmployees() {
        // Set up mock data
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(mockEmployee(1, "Test", "Employee"));
        mockEmployees.add(mockEmployee(2, "Test2", "Employee2"));

        // Set up mock behavior
        when(employeeService.getAllEmployees()).thenReturn(mockEmployees);

        // Call the method
        List<Employee> result = employeeController.getAllEmployees();

        // Verify
        assertEquals(2, result.size());
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    public void testGetEmployeeById() {
        // Set up mock data
        Employee mockEmp = mockEmployee(1, "Test", "Employee");

        // Set up mock behavior
        when(employeeService.getEmployeeById(1)).thenReturn(mockEmp);

        // Call the method
        Employee result = employeeController.getEmployeeById(1);

        // Verify
        assertNotNull(result);
        assertEquals(1, result.getEmployeeId());
        assertEquals("Test", result.getLastName());
        verify(employeeService, times(1)).getEmployeeById(1);
    }

    @Test
    public void testAddEmployee() {
        Employee mockEmp = mockEmployee(1, "Test", "Employee");

        employeeController.addEmployee(mockEmp);

        verify(employeeService, times(1)).addEmployee(mockEmp);
    }

    @Test
    public void testUpdateEmployee() {
        Employee mockEmp = mockEmployee(1, "Test", "Employee");

        employeeController.updateEmployee(mockEmp);

        verify(employeeService, times(1)).updateEmployee(mockEmp);
    }

    @Test
    public void testDeleteEmployee() {
        employeeController.deleteEmployee(1);

        verify(employeeService, times(1)).deleteEmployee(1);
    }

    @Test
    public void testLogin() {
        Employee mockEmp = mockEmployee(1, "Test", "Employee");

        when(employeeService.login("Employee1", "1")).thenReturn(mockEmp);

        Employee result = employeeController.login("Employee1", "1");

        assertNotNull(result);
        assertEquals(1, result.getEmployeeId());
        verify(employeeService, times(1)).login("Employee1", "1");
    }

    @Test
    public void testSaveEmployees() {
        when(employeeService.saveEmployees()).thenReturn(true);

        boolean result = employeeController.saveEmployees();

        assertTrue(result);
        verify(employeeService, times(1)).saveEmployees();
    }

    @Test
    public void testGenerateNewEmployeeId() {
        when(employeeService.generateNewEmployeeId()).thenReturn(3);

        int result = employeeController.generateNewEmployeeId();

        assertEquals(3, result);
        verify(employeeService, times(1)).generateNewEmployeeId();
    }
}


/* package com.motorph.payroll.controller.test;

import com.motorph.payroll.controller.EmployeeController;
import com.motorph.payroll.model.Employee;
import com.motorph.payroll.model.RegularEmployee;
import com.motorph.payroll.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    
    @Mock
    private EmployeeService employeeService;
    
    private EmployeeController employeeController;
    
    @BeforeEach
    public void setUp() {
        employeeController = new EmployeeController(employeeService);
    }
    
    @Test
    public void testGetAllEmployees() {
        // Set up mock data
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new RegularEmployee(1, "Test", "Employee", "01/01/1990", "", "", "", "", "", "", 
                                      "Regular", "", "", 0, 0, 0, 0, 0, 0));
        mockEmployees.add(new RegularEmployee(2, "Test2", "Employee2", "02/02/1992", "", "", "", "", "", "", 
                                      "Regular", "", "", 0, 0, 0, 0, 0, 0));
        
        // Set up mock behavior
        when(employeeService.getAllEmployees()).thenReturn(mockEmployees);
        
        // Call the method
        List<Employee> result = employeeController.getAllEmployees();
        
        // Verify
        assertEquals(2, result.size());
        verify(employeeService, times(1)).getAllEmployees();
    }
    
    @Test
    public void testGetEmployeeById() {
        // Set up mock data
        Employee mockEmployee = new Employee(1, "Test", "Employee", "01/01/1990", "", "", "", "", "", "", 
                                           "Regular", "", "", 0, 0, 0, 0, 0, 0);
        
        // Set up mock behavior
        when(employeeService.getEmployeeById(1)).thenReturn(mockEmployee);
        
        // Call the method
        Employee result = employeeController.getEmployeeById(1);
        
        // Verify
        assertNotNull(result);
        assertEquals(1, result.getEmployeeId());
        assertEquals("Test", result.getLastName());
        verify(employeeService, times(1)).getEmployeeById(1);
    }
    
    @Test
    public void testAddEmployee() {
        // Set up mock data
        Employee mockEmployee = new Employee(1, "Test", "Employee", "01/01/1990", "", "", "", "", "", "", 
                                           "Regular", "", "", 0, 0, 0, 0, 0, 0);
        
        // Call the method
        employeeController.addEmployee(mockEmployee);
        
        // Verify
        verify(employeeService, times(1)).addEmployee(mockEmployee);
    }
    
    @Test
    public void testUpdateEmployee() {
        // Set up mock data
        Employee mockEmployee = new RegularEmployee(1, "Test", "Employee", "01/01/1990", "", "", "", "", "", "", 
                                           "Regular", "", "", 0, 0, 0, 0, 0, 0);
        
        // Call the method
        employeeController.updateEmployee(mockEmployee);
        
        // Verify
        verify(employeeService, times(1)).updateEmployee(mockEmployee);
    }
    
    @Test
    public void testDeleteEmployee() {
        // Call the method
        employeeController.deleteEmployee(1);
        
        // Verify
        verify(employeeService, times(1)).deleteEmployee(1);
    }
    
    @Test
    public void testLogin() {
        // Set up mock data
        Employee mockEmployee = new RegularEmployee(1, "Test", "Employee", "01/01/1990", "", "", "", "", "", "", 
                                           "Regular", "", "", 0, 0, 0, 0, 0);
        
        // Set up mock behavior
        when(employeeService.login("Employee1", "1")).thenReturn(mockEmployee);
        
        // Call the method
        Employee result = employeeController.login("Employee1", "1");
        
        // Verify
        assertNotNull(result);
        assertEquals(1, result.getEmployeeId());
        verify(employeeService, times(1)).login("Employee1", "1");
    }
    
    @Test
    public void testSaveEmployees() {
        // Set up mock behavior
        when(employeeService.saveEmployees()).thenReturn(true);
        
        // Call the method
        boolean result = employeeController.saveEmployees();
        
        // Verify
        assertTrue(result);
        verify(employeeService, times(1)).saveEmployees();
    }
    
    @Test
    public void testGenerateNewEmployeeId() {
        // Set up mock behavior
        when(employeeService.generateNewEmployeeId()).thenReturn(3);
        
        // Call the method
        int result = employeeController.generateNewEmployeeId();
        
        // Verify
        assertEquals(3, result);
        verify(employeeService, times(1)).generateNewEmployeeId();
    }
} */

