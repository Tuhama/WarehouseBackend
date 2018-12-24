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
@Table(name = "sellInv")
public class SellInv {

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
    @Column(name = "pay_cheque_num")
    private Integer payChequeNum;

    @Basic
    @Column(name = "payment_type")
    private Integer paymentType;

    @Basic
    @Column(name = "pay_cheque_date")
    private Date payChequeDate;

    @Basic
    @Column(name = "w_man")
    private Integer wMan;

    @OneToMany(mappedBy = "sellInv")
    private List<ExternDelivery> externDeliveries = new ArrayList<ExternDelivery>();

    @ManyToOne
    @JoinColumn(name = "ext_contact_id", referencedColumnName = "id", nullable = false)
    private ExternalContact externalContact;

    @OneToMany(mappedBy = "sellInv")
    private List<SellInvDetail> sellInvDetails = new ArrayList<SellInvDetail>();

}
