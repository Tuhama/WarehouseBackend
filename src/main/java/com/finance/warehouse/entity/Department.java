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
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

/*    @OneToMany(mappedBy = "departmentByDepId")
    private Collection<Employee> employeesById;*/

    @OneToMany(mappedBy = "departmentByDepId")
    private List<InternDelivery> internDeliveriesById = new ArrayList<InternDelivery>();

    @OneToMany(mappedBy = "departmentByDepId")
    private List<MatDelReq> matDelReqsById = new ArrayList<MatDelReq>();

    @OneToMany(mappedBy = "departmentByDepId")
    private List<MatPurReq> matPurReqsById = new ArrayList<MatPurReq>();


}
