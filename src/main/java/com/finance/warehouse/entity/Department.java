package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;

/*    @OneToMany(mappedBy = "departmentByDepId")
    private Collection<Employee> employeesById;*/

    @OneToMany(mappedBy = "department")
    private List<InternDelivery> internDeliveries = new ArrayList<InternDelivery>();

/*    @OneToMany(mappedBy = "departmentByDepId")
    private List<MatDelReq> matDelReqsById = new ArrayList<MatDelReq>();*/

    @OneToMany(mappedBy = "department")
    private List<MatPurReq> matPurReqs = new ArrayList<MatPurReq>();


}
