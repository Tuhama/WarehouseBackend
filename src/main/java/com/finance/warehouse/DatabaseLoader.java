package com.finance.warehouse;


import com.finance.warehouse.entity.*;
import com.finance.warehouse.repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    PasswordEncoder passwordEncoder;

    public static final String[] POSITIONS = {"دارس", "رئيس قسم", "رئيس دائرة", "رئيس شعبة","مهندس"};

    public static final String[] DEPARTMENTS = {"شؤون إدارية", "شؤون فنية", "معلوماتية"};

    public static final String[] UNITS = {"قلم", "دزينة"};


    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;
    private final EmployeeRepository employeeRepository;

    private final UnitRepository unitRepository;
    private final MaterialRepository materialRepository;
    private final SubMaterialRepository subMaterialRepository;

    @Autowired
    public DatabaseLoader(RoleRepository roleRepository, UserRepository userRepository,
                          DepartmentRepository departmentRepository, PositionRepository positionRepository,
                          UnitRepository unitRepository, MaterialRepository materialRepository,
                          SubMaterialRepository subMaterialRepository, EmployeeRepository employeeRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
        this.employeeRepository = employeeRepository;
        this.unitRepository = unitRepository;
        this.materialRepository = materialRepository;
        this.subMaterialRepository = subMaterialRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        ////save roles to database
        this.roleRepository.save(new Role(RoleName.ROLE_USER));
        this.roleRepository.save(new Role(RoleName.ROLE_ADMIN));


        /////
/*        Set<Role> setA = new HashSet<Role>();

        setA.add(this.roleRepository.findByName(RoleName.ROLE_ADMIN));*/

        User u = new User("tu", "tu", "tu@tu.com", "tu");

        u.setPassword(passwordEncoder.encode(u.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                /*.orElseThrow(() -> new AppException("User Role not set."))*/;

        u.setRoles(Collections.singleton(userRole));

        this.userRepository.save(u);


        ///save positions to database
        for (int i = 0; i < POSITIONS.length; i++) {
            this.positionRepository.save(new Position(POSITIONS[i]));
        }
        Position engineer = this.positionRepository.findByName("مهندس");


        ///save departments to database
        for (int i = 0; i < DEPARTMENTS.length; i++) {
            this.departmentRepository.save(new Department(DEPARTMENTS[i]));
        }
        Department it = this.departmentRepository.findByName("معلوماتية");

        employeeRepository.save(
                new Employee(111111111, "اريج", "قيصر", "منى", "اورفلي", it, engineer)
        );
        employeeRepository.save(
                new Employee(222222222, "رهام", "بسام", "غادة", "مصلا", it, engineer)
        );
        ///save units to database
        for (int i = 0; i < UNITS.length; i++) {
            this.unitRepository.save(new Unit(UNITS[i]));
        }
        Unit piece = this.unitRepository.findByName("قلم");
        Unit dozen = this.unitRepository.findByName("دزينة");


        Material[] MATERIALS = new Material[]{
                new Material("دفاتر", dozen, ""),
                new Material("أقلام", dozen, ""),
                new Material("اجهزة حاسوب", piece, ""),
                new Material("أثاث", piece, "")};

        for (int i = 0; i < MATERIALS.length; i++) {
            this.materialRepository.save(MATERIALS[i]);
        }


        Material copybook = this.materialRepository.findByName("دفاتر");
        Material laps = this.materialRepository.findByName("اجهزة حاسوب");

        SubMaterial[] SUBMATERIALS = new SubMaterial[]{
                new SubMaterial("دفتر كتابة", 2, copybook),
                // new SubMaterial("أقلام", 10, ""),
                new SubMaterial("لينوفو", 5, laps),
        };
        for (int i = 0; i < SUBMATERIALS.length; i++) {
            this.subMaterialRepository.save(SUBMATERIALS[i]);
        }


    }


}
