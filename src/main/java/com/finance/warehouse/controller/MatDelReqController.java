package com.finance.warehouse.controller;


import com.finance.warehouse.entity.MatDelReq;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.MatDelReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MatDelReqController {

    @Autowired
    MatDelReqRepository matDelReqRepository;


    // Get All MatDelReqs
    @GetMapping("/matDelReqs")
    public List<MatDelReq> getAllMatDelReqs() {
        System.out.println(matDelReqRepository.findAll());
        return matDelReqRepository.findAll();
    }


    // Create a new MatDelReq
    @PostMapping("/matDelReqs")
    public MatDelReq createMatDelReq(@Valid @RequestBody MatDelReq matDelReq) {
        System.out.println(matDelReq);
        return matDelReqRepository.save(matDelReq);
    }


    // Get a Single MatDelReq
    @GetMapping("/matDelReqs/{id}")
    public MatDelReq getMatDelReqById(@PathVariable(value = "id") Integer matDelReqId) {
        return matDelReqRepository.findById(matDelReqId)
                .orElseThrow(() -> new ResourceNotFoundException("MatDelReq", "id", matDelReqId));
    }
    // Update a MatDelReq
    @PutMapping("/matDelReqs/{id}")
    public MatDelReq updateMatDelReq(@PathVariable(value = "id") Integer matDelReqId,
                                 @Valid @RequestBody MatDelReq matDelReqDetails) {

        MatDelReq matDelReq = matDelReqRepository.findById(matDelReqId)
                .orElseThrow(() -> new ResourceNotFoundException("MatDelReq", "id", matDelReqId));

       // matDelReq.setName(matDelReqDetails.getName());


        MatDelReq updatedMatDelReq = matDelReqRepository.save(matDelReq);
        return updatedMatDelReq;
    }

    // Delete a MatDelReq
    @DeleteMapping("/matDelReqs/{id}")
    public ResponseEntity<?> deleteMatDelReq(@PathVariable(value = "id") Integer matDelReqId) {
        MatDelReq matDelReq = matDelReqRepository.findById(matDelReqId)
                .orElseThrow(() -> new ResourceNotFoundException("MatDelReq", "id", matDelReqId));

        matDelReqRepository.delete(matDelReq);

        return ResponseEntity.ok().build();
    }
}
