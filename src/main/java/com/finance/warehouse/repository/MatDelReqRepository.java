package com.finance.warehouse.repository;

import com.finance.warehouse.entity.MatDelReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MatDelReqRepository extends JpaRepository<MatDelReq, Integer> {
}
