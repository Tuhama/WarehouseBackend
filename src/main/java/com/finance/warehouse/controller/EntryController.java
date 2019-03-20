package com.finance.warehouse.controller;


import com.finance.warehouse.entity.Entry;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class EntryController {

    @Autowired
    EntryRepository entryRepository;


    // Get All Entrys
    @GetMapping("/entrys")
    public List<Entry> getAllEntrys() {
        System.out.println(entryRepository.findAll());
        return entryRepository.findAll();
    }


    // Create a new Entry
    @PostMapping("/entrys")
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        System.out.println(entry);
        return entryRepository.save(entry);
    }


    // Get a Single Entry
    @GetMapping("/entrys/{id}")
    public Entry getEntryById(@PathVariable(value = "id") Integer entryId) {
        return entryRepository.findById(entryId)
                .orElseThrow(() -> new ResourceNotFoundException("Entry", "id", entryId));
    }
    // Update a Entry
    @PutMapping("/entrys/{id}")
    public Entry updateEntry(@PathVariable(value = "id") Integer entryId,
                                 @Valid @RequestBody Entry entryDetails) {

        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(() -> new ResourceNotFoundException("Entry", "id", entryId));

       // entry.setName(entryDetails.getName());


        Entry updatedEntry = entryRepository.save(entry);
        return updatedEntry;
    }

    // Delete a Entry
    @DeleteMapping("/entrys/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable(value = "id") Integer entryId) {
        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(() -> new ResourceNotFoundException("Entry", "id", entryId));

        entryRepository.delete(entry);

        return ResponseEntity.ok().build();
    }
}
