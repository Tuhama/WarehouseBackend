package com.finance.warehouse.controller;


import com.finance.warehouse.entity.Department;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;


    // Get All departments
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }


    // Create a new department
    @PostMapping("/departments")
    public Department createDepartment(@Valid @RequestBody Department department) {
        System.out.println(department);
        return departmentRepository.save(department);
    }


    // Get a Single department
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable(value = "id") Integer departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId));
    }
    // Update a Department
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable(value = "id") Integer departmentId,
                                 @Valid @RequestBody Department departmentDetails) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", departmentId));

        department.setName(departmentDetails.getName());
        

        Department updatedDepartment = departmentRepository.save(department);
        return updatedDepartment;
    }

    // Delete a Department
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(value = "id") Integer departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentId));

        departmentRepository.delete(department);

        return ResponseEntity.ok().build();
    }
}
