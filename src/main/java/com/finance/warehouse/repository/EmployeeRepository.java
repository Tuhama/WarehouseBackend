package com.finance.warehouse.repository;

import com.finance.warehouse.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {


    List<Employee> findByPositionId(Integer positionId);
    List<Employee> findByDepartmentId(Integer depId);
}
