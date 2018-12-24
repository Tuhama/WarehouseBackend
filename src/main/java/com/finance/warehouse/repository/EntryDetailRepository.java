package com.finance.warehouse.repository;

import com.finance.warehouse.entity.EntryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryDetailRepository extends JpaRepository<EntryDetail, Integer> {
}
