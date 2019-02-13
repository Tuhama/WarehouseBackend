package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "matPurReqDetail")
public class MatPurReqDetail {

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


    @Column(name = "approx_price")
    private Long approxPrice;


    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "mat_pur_id", referencedColumnName = "id", nullable = false)
    private MatPurReq matPurReq;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;

}
