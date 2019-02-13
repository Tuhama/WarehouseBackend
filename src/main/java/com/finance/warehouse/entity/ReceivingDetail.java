package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "receivingDetail")
public class ReceivingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "description")
    private String description;


    @Column(name = "amount")
    private int amount;


    @Column(name = "price")
    private Long price;


    @Column(name = "total_price")
    private Long totalPrice;


    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "receiving_id", referencedColumnName = "id", nullable = false)
    private Receiving receiving;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;


}
