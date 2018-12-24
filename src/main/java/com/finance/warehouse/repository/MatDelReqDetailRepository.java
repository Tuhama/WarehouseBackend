package com.finance.warehouse.repository;

import com.finance.warehouse.entity.MatDelReqDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MatDelReqDetailRepository extends JpaRepository<MatDelReqDetail, Integer> {
}
