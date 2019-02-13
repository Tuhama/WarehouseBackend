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
@Table(name = "internDelivery")
public class InternDelivery {

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


    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "internDelivery")
    private Collection<Custody> custodies;

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "mat_req_id", referencedColumnName = "id", nullable = false)
    private MatDelReq matDelReq;

    @ManyToOne
    @JoinColumn(name = "w_man_id", referencedColumnName = "id", nullable = false)
    private Employee wMan;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = false)
    private Employee receiver;

    @OneToMany(mappedBy = "internDelivery")
    private List<InternDeliveryDetail> internDeliveryDetails = new ArrayList<InternDeliveryDetail>();

}
