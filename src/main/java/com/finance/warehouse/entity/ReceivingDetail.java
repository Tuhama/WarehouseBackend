package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "receivingDetail")
public class ReceivingDetail {

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
    @Column(name = "price")
    private Long price;

    @Basic
    @Column(name = "total_price")
    private Long totalPrice;

    @Basic
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "receiving_id", referencedColumnName = "id", nullable = false)
    private Receiving receivingByReceivingId;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "s_m_id", nullable = false)
    private SubMaterial subMaterialBySMId;


}
