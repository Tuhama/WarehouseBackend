package com.finance.warehouse;


import com.finance.warehouse.entity.Role;
import com.finance.warehouse.entity.RoleName;
import com.finance.warehouse.repository.RoleRepository;


import com.finance.warehouse.entity.Department;
import com.finance.warehouse.repository.DepartmentRepository;


import com.finance.warehouse.entity.Position;
import com.finance.warehouse.repository.PositionRepository;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    public static final String[] POSITIONS = {"دارس", "رئيس قسم","رئيس دائرة","رئيس شعبة"};

    public static final String[] DEPARTMENTS = {"شؤون إدارية", "شؤون فنية","معلوماتية"};



    private final RoleRepository roleRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public DatabaseLoader(RoleRepository roleRepository,DepartmentRepository departmentRepository,PositionRepository positionRepository) {
        this.roleRepository = roleRepository;
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        ////save roles to database
        this.roleRepository.save(new Role(RoleName.ROLE_USER));
        this.roleRepository.save(new Role(RoleName.ROLE_ADMIN));

        ///save positions to database
        for(int i=0; i < POSITIONS.length; i++){
            this.positionRepository.save(new Position(POSITIONS[i]));
        }


        ///save departments to database
        for(int i=0; i < DEPARTMENTS.length; i++){
            this.departmentRepository.save(new Department(DEPARTMENTS[i]));
        }
    }


}
