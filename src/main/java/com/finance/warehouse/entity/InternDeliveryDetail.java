package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "internDeliveryDetail")
public class InternDeliveryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "description")
    private String description;


    @Column(name = "quantity")
    private int quantity;


    @Column(name = "amount")
    private int amount;


    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "internal_delivery_id", referencedColumnName = "id", nullable = false)
    private InternDelivery internDelivery;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;

    @ManyToOne
    @JoinColumn(name = "user_emp_id", referencedColumnName = "id")
    private Employee user;

}
