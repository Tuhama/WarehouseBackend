package com.finance.warehouse.repository;

import com.finance.warehouse.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
