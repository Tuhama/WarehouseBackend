package com.finance.warehouse.repository;

import com.finance.warehouse.entity.SubMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMaterialRepository extends JpaRepository<SubMaterial, Integer> {
    SubMaterial findByName(String subMaterialName);
}
