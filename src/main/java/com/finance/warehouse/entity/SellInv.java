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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "folder_num")
    private String folderNum;


    @Column(name = "serial")
    private String serial;


    @Column(name = "date")
    private Date date;



    @Column(name = "pay_cheque_num")
    private Integer payChequeNum;


    @Column(name = "payment_type")
    private Integer paymentType;


    @Column(name = "pay_cheque_date")
    private Date payChequeDate;


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
