package com.finance.warehouse.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "matDelReqDetail")
public class MatDelReqDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "description")
    private String description;


    @Column(name = "amount")
    private int amount;


    @Column(name = "purpose")
    private String purpose;


    @Column(name = "prev_dell_amount")
    private Integer prevDellAmount;


    @Column(name = "prev_dell_date")
    private Date prevDellDate;


    @Column(name = "allowed_amount")
    private Integer allowedAmount;


    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "mat_req_id", referencedColumnName = "id", nullable = false)
    private MatDelReq matDelReq;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;

}
