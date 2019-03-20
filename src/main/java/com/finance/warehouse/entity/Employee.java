package com.finance.warehouse.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "employee")
public
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "nat_id")
    private long natId;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "f_name")
    private String fName;

    @NonNull
    @Column(name = "m_name")
    private String mName;

    @NonNull
    @Column(name = "l_name")
    private String lName;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    private Department department;

    @NonNull
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
