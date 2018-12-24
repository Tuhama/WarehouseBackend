package com.finance.warehouse.controller;


import com.finance.warehouse.entity.SubMaterial;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.SubMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SubMaterialController {

    @Autowired
    SubMaterialRepository subMaterialRepository;


    // Get All SubMaterials
    @GetMapping("/subMaterials")
    public List<SubMaterial> getAllSubMaterials() {
        System.out.println(subMaterialRepository.findAll());
        return subMaterialRepository.findAll();
    }


    // Create a new SubMaterial
    @PostMapping("/subMaterials")
    public SubMaterial createSubMaterial(@Valid @RequestBody SubMaterial subMaterial) {
        System.out.println(subMaterial);
        return subMaterialRepository.save(subMaterial);
    }


    // Get a Single SubMaterial
    @GetMapping("/subMaterials/{id}")
    public SubMaterial getSubMaterialById(@PathVariable(value = "id") Integer subMaterialId) {
        return subMaterialRepository.findById(subMaterialId)
                .orElseThrow(() -> new ResourceNotFoundException("SubMaterial", "id", subMaterialId));
    }
    // Update a SubMaterial
    @PutMapping("/subMaterials/{id}")
    public SubMaterial updateSubMaterial(@PathVariable(value = "id") Integer subMaterialId,
                                 @Valid @RequestBody SubMaterial subMaterialDetails) {

        SubMaterial subMaterial = subMaterialRepository.findById(subMaterialId)
                .orElseThrow(() -> new ResourceNotFoundException("SubMaterial", "id", subMaterialId));

       // subMaterial.setName(subMaterialDetails.getName());


        SubMaterial updatedSubMaterial = subMaterialRepository.save(subMaterial);
        return updatedSubMaterial;
    }

    // Delete a SubMaterial
    @DeleteMapping("/subMaterials/{id}")
    public ResponseEntity<?> deleteSubMaterial(@PathVariable(value = "id") Integer subMaterialId) {
        SubMaterial subMaterial = subMaterialRepository.findById(subMaterialId)
                .orElseThrow(() -> new ResourceNotFoundException("SubMaterial", "id", subMaterialId));

        subMaterialRepository.delete(subMaterial);

        return ResponseEntity.ok().build();
    }
}
