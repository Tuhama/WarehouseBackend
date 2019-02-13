package com.finance.warehouse;


import com.finance.warehouse.entity.Role;
import com.finance.warehouse.entity.RoleName;
import com.finance.warehouse.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final RoleRepository repository;

    @Autowired
    public DatabaseLoader(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Role(RoleName.ROLE_USER));
        this.repository.save(new Role(RoleName.ROLE_ADMIN));
    }


}
