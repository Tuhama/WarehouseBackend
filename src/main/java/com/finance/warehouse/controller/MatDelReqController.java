package com.finance.warehouse.controller;


import com.finance.warehouse.entity.MatDelReq;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.payload.request.MatDelReqDTO;
import com.finance.warehouse.payload.ApiResponse;
import com.finance.warehouse.repository.MatDelReqRepository;
import com.finance.warehouse.service.MatDelReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/auth")
public class MatDelReqController {

    @Autowired
    MatDelReqRepository matDelReqRepository;
    @Autowired
    private MatDelReqService matDelReqService;

    // Get All MatDelReqs
    @GetMapping("/matDelReqs")
    public List<MatDelReq> getAllMatDelReqs() {
        System.out.println(matDelReqRepository.findAll());
        return matDelReqRepository.findAll();
    }



    // Create a new MatDelReq
    @PostMapping("/matDelReqs")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createMatDelReq(@Valid @RequestBody MatDelReqDTO req) {

        MatDelReq matReq = matDelReqService.createMatDelReq(req);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{matReqId}")
                .buildAndExpand(matReq.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Poll Created Successfully"));
    }




    // Get a Single MatDelReq
    @GetMapping("/matDelReqs/{id}")
    @PreAuthorize("hasRole('USER')")
    public MatDelReq getMatDelReqById(@PathVariable(value = "id") Long matDelReqId) {
        return matDelReqRepository.findById(matDelReqId)
                .orElseThrow(() -> new ResourceNotFoundException("MatDelReq", "id", matDelReqId));
    }


    // Update a MatDelReq
    @PutMapping("/matDelReqs/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MatDelReq updateMatDelReq(@PathVariable(value = "id") Long matDelReqId,
                                 @Valid @RequestBody MatDelReq matDelReqDetails) {

        MatDelReq matDelReq = matDelReqRepository.findById(matDelReqId)
                .orElseThrow(() -> new ResourceNotFoundException("MatDelReq", "id", matDelReqId));

       // matDelReq.setName(matDelReqDetails.getName());


        MatDelReq updatedMatDelReq = matDelReqRepository.save(matDelReq);
        return updatedMatDelReq;
    }

    // Delete a MatDelReq
    @DeleteMapping("/matDelReqs/{id}")
    public ResponseEntity<?> deleteMatDelReq(@PathVariable(value = "id") Long matDelReqId) {
        MatDelReq matDelReq = matDelReqRepository.findById(matDelReqId)
                .orElseThrow(() -> new ResourceNotFoundException("MatDelReq", "id", matDelReqId));

        matDelReqRepository.delete(matDelReq);

        return ResponseEntity.ok().build();
    }
}
