package com.finance.warehouse.controller;


import com.finance.warehouse.entity.Position;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class PositionController {

    @Autowired
    PositionRepository positionRepository;


    // Get All Positions
    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        System.out.println(positionRepository.findAll());
        return positionRepository.findAll();
    }


    // Create a new Position
    @PostMapping("/positions")
    public Position createPosition(@Valid @RequestBody Position position) {
        System.out.println(position);
        return positionRepository.save(position);
    }


    // Get a Single Position
    @GetMapping("/positions/{id}")
    public Position getPositionById(@PathVariable(value = "id") Integer positionId) {
        return positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", positionId));
    }
    // Update a Position
    @PutMapping("/positions/{id}")
    public Position updatePosition(@PathVariable(value = "id") Integer positionId,
                                 @Valid @RequestBody Position positionDetails) {

        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", positionId));

       // position.setName(positionDetails.getName());


        Position updatedPosition = positionRepository.save(position);
        return updatedPosition;
    }

    // Delete a Position
    @DeleteMapping("/positions/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable(value = "id") Integer positionId) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", positionId));

        positionRepository.delete(position);

        return ResponseEntity.ok().build();
    }
}
