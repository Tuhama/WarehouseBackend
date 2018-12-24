package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "nat_id")
    private long natId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "f_name")
    private String fName;

    @Basic
    @Column(name = "m_name")
    private String mName;

    @Basic
    @Column(name = "l_name")
    private String lName;


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

/*    @OneToMany(mappedBy = "employeeByEmpId")
    private List<Custody> custodiesById  = new ArrayList<Custody>();

    @OneToMany(mappedBy = "employeeByEmpId")
    private List<Entry> entriesById  = new ArrayList<Entry>();

    @OneToMany(mappedBy = "employeeByWManId")
    private List<InternDelivery> internDeliveriesById  = new ArrayList<InternDelivery>();

    @OneToMany(mappedBy = "employeeByReceiverId")
    private List<InternDelivery> internDeliveriesById_0  = new ArrayList<InternDelivery>();

    @OneToMany(mappedBy = "employeeByUserEmpId")
    private List<InternDeliveryDetail> internDeliveryDetailsById  = new ArrayList<InternDeliveryDetail>();

    @OneToMany(mappedBy = "employeeByApplicantEmpId")
    private List<MatDelReq> matDelReqsById  = new ArrayList<MatDelReq>();*/


}
