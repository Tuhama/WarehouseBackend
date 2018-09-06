package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "internDeliveryDetail")
public class InternDeliveryDetail {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "quantity")
    private int quantity;

    @Basic
    @Column(name = "amount")
    private int amount;

    @Basic
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "internal_delivery_id", referencedColumnName = "id", nullable = false)
    private InternDelivery internDeliveryByInternalDeliveryId;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "s_m_id", nullable = false)
    private SubMaterial subMaterialBySMId;

    @ManyToOne
    @JoinColumn(name = "user_emp_id", referencedColumnName = "id")
    private Employee employeeByUserEmpId;

}
