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
@Table(name = "receiving")
public class Receiving {

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


    @Column(name = "bill_date")
    private Date billDate;


    @Column(name = "bill_num")
    private String billNum;



    @Column(name = "w_man_id")
    private int wManId;


    @Column(name = "deliverer")
    private String deliverer;


    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "pur_req_id", referencedColumnName = "id")
    private MatPurReq matPurReq;

    @OneToMany(mappedBy = "receiving")
    private List<ReceivingDetail> receivingDetails = new ArrayList<ReceivingDetail>();

}
