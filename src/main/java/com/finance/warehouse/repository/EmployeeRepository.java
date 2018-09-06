package com.finance.warehouse.repository;

import com.finance.warehouse.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    Page<Employee> findByPositionId(Long positionId, Pageable pageable);
    Page<Employee> findByDepId(Long depId, Pageable pageable);
}
