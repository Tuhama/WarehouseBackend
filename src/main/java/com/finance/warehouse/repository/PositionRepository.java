package com.finance.warehouse.repository;

import com.finance.warehouse.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository  extends JpaRepository<Position, Integer> {
    Position findByName(String positionName);
}
