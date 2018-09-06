package com.finance.warehouse.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "matDelReqDetail")
public class MatDelReqDetail {

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
    @Column(name = "prev_dell_amount")
    private Integer prevDellAmount;

    @Basic
    @Column(name = "prev_dell_date")
    private Date prevDellDate;

    @Basic
    @Column(name = "allowed_amount")
    private Integer allowedAmount;

    @Basic
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "mat_req_id", referencedColumnName = "id", nullable = false)
    private MatDelReq matDelReqByMatReqId;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "s_m_id", nullable = false)
    private SubMaterial subMaterialBySMId;

}
