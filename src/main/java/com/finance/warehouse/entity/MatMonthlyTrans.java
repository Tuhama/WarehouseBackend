package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "matMonthlyTrans")
public class MatMonthlyTrans {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;


    @Basic
    @Column(name = "prev_quantity")
    private int prevQuantity;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @Basic
    @Column(name = "note")
    private String note;

    @Basic
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;

}
