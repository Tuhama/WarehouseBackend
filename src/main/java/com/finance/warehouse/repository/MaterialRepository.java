package com.finance.warehouse.repository;

import com.finance.warehouse.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
    Material findByName(String materialName);
}
