package com.finance.warehouse.controller;


import com.finance.warehouse.entity.Contact;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.repository.ContactRepository;
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
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    // Get All Contacts
    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


    // Create a new Contact
    @PostMapping("/contacts")
    @PreAuthorize("hasRole('ADMIN')")
    public Contact createContact(@Valid @RequestBody Contact contact) {
        System.out.println(contact);
        return contactRepository.save(contact);
    }


    // Get a Single Contact
    @GetMapping("/contacts/{id}")
    public Contact getContactById(@PathVariable(value = "id") Integer contactId) {
        return contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));
    }
    // Update a Contact
    @PutMapping("/contacts/{id}")
    public Contact updateContact(@PathVariable(value = "id") Integer contactId,
                                 @Valid @RequestBody Contact contactDetails) {

        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));

        contact.setName(contactDetails.getName());
        

        Contact updatedContact = contactRepository.save(contact);
        return updatedContact;
    }

    // Delete a Contact
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable(value = "id") Integer contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));

        contactRepository.delete(contact);

        return ResponseEntity.ok().build();
    }
}
