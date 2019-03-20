package com.finance.warehouse.controller;


import com.finance.warehouse.entity.Employee;
import com.finance.warehouse.entity.Position;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.DepartmentRepository;
import com.finance.warehouse.repository.EmployeeRepository;
import com.finance.warehouse.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class EmployeeController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    // Create a new Employee
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }


    // Get a Single Employee
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }
    // Update a Employee
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Integer employeeId,
                                   @Valid @RequestBody Employee employeeDetails) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

         employee.setName(employeeDetails.getName());


        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    // Delete a Employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }

}

