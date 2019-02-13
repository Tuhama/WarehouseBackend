package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "inventoryDetail")
public class InventoryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "price")
    private long price;


    @Column(name = "actual_quantity")
    private int actualQuantity;


    @Column(name = "diff_plus")
    private int diffPlus;


    @Column(name = "diff_minus")
    private int diffMinus;


    @Column(name = "w_man_note")
    private String wManNote;


    @Column(name = "head_w_note")
    private String headWNote;


    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "inv_id", referencedColumnName = "id", nullable = false)
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;


}
