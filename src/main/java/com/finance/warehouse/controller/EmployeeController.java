package com.finance.warehouse.controller;


import com.finance.warehouse.repository.DepartmentRepository;
import com.finance.warehouse.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PositionRepository positionRepository;



}

