package com.finance.warehouse.repository;

import com.finance.warehouse.entity.Role;
import com.finance.warehouse.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName roleName);
}
