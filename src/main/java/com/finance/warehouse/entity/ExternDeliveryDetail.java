package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "externDeliveryDetail")
public class ExternDeliveryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "description")
    private String description;


    @Column(name = "amount")
    private int amount;


    @Column(name = "quantity")
    private int quantity;


    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "external_delivery_id", referencedColumnName = "id", nullable = false)
    private ExternDelivery externDelivery;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;

}
