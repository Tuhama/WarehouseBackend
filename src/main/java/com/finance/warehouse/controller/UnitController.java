package com.finance.warehouse.controller;


import com.finance.warehouse.entity.Unit;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.UnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UnitController {
    @Autowired
    UnitRepository unitRepository;

    private static final Logger logger = LoggerFactory.getLogger(UnitController.class);

    // Get All Units
    @GetMapping("/units")
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }


    // Create a new Unit
    @PostMapping("/units")
    @PreAuthorize("hasRole('ADMIN')")
    public Unit createUnit(@Valid @RequestBody Unit unit) {
        System.out.println(unit);
        return unitRepository.save(unit);
    }


    // Get a Single Unit
    @GetMapping("/units/{id}")
    public Unit getUnitById(@PathVariable(value = "id") Integer unitId) {
        return unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("Unit", "id", unitId));
    }
    // Update a Unit
    @PutMapping("/units/{id}")
    public Unit updateUnit(@PathVariable(value = "id") Integer unitId,
                                 @Valid @RequestBody Unit unitDetails) {

        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("Unit", "id", unitId));

        unit.setName(unitDetails.getName());


        Unit updatedUnit = unitRepository.save(unit);
        return updatedUnit;
    }

    // Delete a Unit
    @DeleteMapping("/units/{id}")
    public ResponseEntity<?> deleteUnit(@PathVariable(value = "id") Integer unitId) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("Unit", "id", unitId));

        unitRepository.delete(unit);

        return ResponseEntity.ok().build();
    }
}
