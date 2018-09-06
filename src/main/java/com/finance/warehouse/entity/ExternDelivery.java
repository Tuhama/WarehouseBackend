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

    @Basic
    @Column(name = "w_man_id")
    private int wManId;

    @Basic
    @Column(name = "receiver")
    private String receiver;


    @Basic
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "sell_bill_id", referencedColumnName = "id", nullable = false)
    private SellInv sellInvBySellBillId;

    @ManyToOne
    @JoinColumn(name = "ext_contact_id", referencedColumnName = "id", nullable = false)
    private ExternalContact externalContactByExtContactId;

    @OneToMany(mappedBy = "externDeliveryByExternalDeliveryId")
    private List<ExternDeliveryDetail> externDeliveryDetailsById = new ArrayList<ExternDeliveryDetail>();


}
