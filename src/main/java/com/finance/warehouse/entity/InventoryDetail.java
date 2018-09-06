package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "inventoryDetail")
public class InventoryDetail {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "price")
    private long price;

    @Basic
    @Column(name = "actual_quantity")
    private int actualQuantity;

    @Basic
    @Column(name = "diff_plus")
    private int diffPlus;

    @Basic
    @Column(name = "diff_minus")
    private int diffMinus;

    @Basic
    @Column(name = "w_man_note")
    private String wManNote;

    @Basic
    @Column(name = "head_w_note")
    private String headWNote;

    @Basic
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "inv_id", referencedColumnName = "id", nullable = false)
    private Inventory inventoryByInvId;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "s_m_id", nullable = false)
    private SubMaterial subMaterialBySMId;


}
