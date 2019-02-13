package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "sellInvDetail")
public class SellInvDetail {

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


    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "sell_inv_id", referencedColumnName = "id", nullable = false)
    private SellInv sellInv;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;

}
