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
@Table(name = "matPurReq")
public class MatPurReq {

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

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "matPurReq")
    private List<MatPurReqDetail> matPurReqDetails = new ArrayList<MatPurReqDetail>();

    @OneToMany(mappedBy = "matPurReq")
    private List<Receiving> receivings = new ArrayList<Receiving>();

}
