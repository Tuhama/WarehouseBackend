package com.finance.warehouse.repository;

import com.finance.warehouse.entity.MatDelReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatDelReqRepository extends JpaRepository<MatDelReq, Long> {
    Optional<MatDelReq> findById(Long matdelreqId);

    Page<MatDelReq> findByCreatedBy(Long userId, Pageable pageable);

    long countByCreatedBy(Long userId);

    List<MatDelReq> findByIdIn(List<Long> matdelreqIds);

    List<MatDelReq> findByIdIn(List<Long> matdelreqIds, Sort sort);
}
