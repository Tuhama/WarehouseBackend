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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "folder_num")
    private String folderNum;


    @Column(name = "serial")
    private String serial;


    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "matDelReq")
    private List<InternDelivery> internDeliveries = new ArrayList<InternDelivery>();

/*    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    private Department departmentByDepId;*/

    @ManyToOne
    @JoinColumn(name = "applicant_emp_id", referencedColumnName = "id")
    private Employee applicant;

    @OneToMany(mappedBy = "matDelReq")
    private List<MatDelReqDetail> matDelReqDetails = new ArrayList<MatDelReqDetail>();


}
