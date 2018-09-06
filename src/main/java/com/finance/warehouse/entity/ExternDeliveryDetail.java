package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "externDeliveryDetail")
public class ExternDeliveryDetail {

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
    @Column(name = "quantity")
    private int quantity;

    @Basic
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "external_delivery_id", referencedColumnName = "id", nullable = false)
    private ExternDelivery externDeliveryByExternalDeliveryId;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "s_m_id", nullable = false)
    private SubMaterial subMaterialBySMId;

}
