package com.finance.warehouse.repository;
import com.finance.warehouse.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {
    Unit findByName(String unitName);
}

