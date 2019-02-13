package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "entryDetail")
public class EntryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "description")
    private String description;


    @Column(name = "amount")
    private int amount;


    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "entry_id", referencedColumnName = "id", nullable = false)
    private Entry entry;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;

}
