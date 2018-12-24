package com.finance.warehouse.controller;


import com.finance.warehouse.entity.Material;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MaterialController {

    @Autowired
    MaterialRepository materialRepository;


    // Get All Materials
    @GetMapping("/materials")
    public List<Material> getAllMaterials() {
        System.out.println(materialRepository.findAll());
        return materialRepository.findAll();
    }


    // Create a new Material
    @PostMapping("/materials")
    public Material createMaterial(@Valid @RequestBody Material material) {
        System.out.println(material);
        return materialRepository.save(material);
    }


    // Get a Single Material
    @GetMapping("/materials/{id}")
    public Material getMaterialById(@PathVariable(value = "id") Integer materialId) {
        return materialRepository.findById(materialId)
                .orElseThrow(() -> new ResourceNotFoundException("Material", "id", materialId));
    }
    // Update a Material
    @PutMapping("/materials/{id}")
    public Material updateMaterial(@PathVariable(value = "id") Integer materialId,
                                 @Valid @RequestBody Material materialDetails) {

        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new ResourceNotFoundException("Material", "id", materialId));

       // material.setName(materialDetails.getName());


        Material updatedMaterial = materialRepository.save(material);
        return updatedMaterial;
    }

    // Delete a Material
    @DeleteMapping("/materials/{id}")
    public ResponseEntity<?> deleteMaterial(@PathVariable(value = "id") Integer materialId) {
        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new ResourceNotFoundException("Material", "id", materialId));

        materialRepository.delete(material);

        return ResponseEntity.ok().build();
    }
}
