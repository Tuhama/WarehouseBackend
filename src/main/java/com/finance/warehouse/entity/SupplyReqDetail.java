package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "supplyReqDetail")
public class SupplyReqDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "description")
    private String description;


    @Column(name = "amount")
    private int amount;


    @Column(name = "contracted_amount")
    private Integer contractedAmount;


    @Column(name = "approx_price")
    private Long approxPrice;


    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "sup_req_id", referencedColumnName = "id", nullable = false)
    private SupplyReq supplyReq;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;

}
