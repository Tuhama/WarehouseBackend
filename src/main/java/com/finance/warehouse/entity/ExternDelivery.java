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
@Table(name = "externDelivery")
public class ExternDelivery {

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


    @Column(name = "w_man_id")
    private int wManId;


    @Column(name = "receiver")
    private String receiver;



    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "sell_bill_id", referencedColumnName = "id", nullable = false)
    private SellInv sellInv;

    @ManyToOne
    @JoinColumn(name = "ext_contact_id", referencedColumnName = "id", nullable = false)
    private ExternalContact externalContact;

    @OneToMany(mappedBy = "externDelivery")
    private List<ExternDeliveryDetail> externDeliveryDetails = new ArrayList<ExternDeliveryDetail>();


}
