package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "matPurReqDetail")
public class MatPurReqDetail {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "amount")
    private int amount;

    @Basic
    @Column(name = "purpose")
    private String purpose;

    @Basic
    @Column(name = "approx_price")
    private Long approxPrice;

    @Basic
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "mat_pur_id", referencedColumnName = "id", nullable = false)
    private MatPurReq matPurReqByMatPurId;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "s_m_id", nullable = false)
    private SubMaterial subMaterialBySMId;

}
