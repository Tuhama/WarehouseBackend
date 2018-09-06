package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "matDelReq")
public class MatDelReq {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "folder_num")
    private String folderNum;

    @Basic
    @Column(name = "serial")
    private String serial;

    @Basic
    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "matDelReqByMatReqId")
    private List<InternDelivery> internDeliveriesById = new ArrayList<InternDelivery>();

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    private Department departmentByDepId;

    @ManyToOne
    @JoinColumn(name = "applicant_emp_id", referencedColumnName = "id")
    private Employee employeeByApplicantEmpId;

    @OneToMany(mappedBy = "matDelReqByMatReqId")
    private List<MatDelReqDetail> matDelReqDetailsById = new ArrayList<MatDelReqDetail>();


}
