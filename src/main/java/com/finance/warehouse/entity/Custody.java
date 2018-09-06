package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "custody")
public class Custody {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;


    @Basic
    @Column(name = "amount")
    private Integer amount;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @Basic
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    private Employee employeeByEmpId;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "s_m_id", nullable = false)
    private SubMaterial subMaterialBySMId;

    @ManyToOne
    @JoinColumn(name = "intenal_delivery_id", referencedColumnName = "id")
    private InternDelivery internDeliveryByIntenalDeliveryId;

    @ManyToOne
    @JoinColumn(name = "entry_id", referencedColumnName = "id")
    private Entry entryByEntryId;

}
