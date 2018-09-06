package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "subMaterial")
public class SubMaterial {

    @Id
    @GeneratedValue
    @Column(name = "s_m_id")
    private int sMId;


    @Basic
    @Column(name = "min")
    private Integer min;

    @Basic
    @Column(name = "max")
    private Integer max;

    @Basic
    @Column(name = "s_m_name")
    private String sMName;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @Basic
    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<Custody> custodiesBySMId = new ArrayList<Custody>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<EntryDetail> entryDetailsBySMId = new ArrayList<EntryDetail>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<ExternDeliveryDetail> externDeliveryDetailsBySMId = new ArrayList<ExternDeliveryDetail>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<InternDeliveryDetail> internDeliveryDetailsBySMId = new ArrayList<InternDeliveryDetail>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<InventoryDetail> inventoryDetailsBySMId = new ArrayList<InventoryDetail>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<MatDelReqDetail> matDelReqDetailsBySMId = new ArrayList<MatDelReqDetail>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<MatMonthlyTrans> matMonthlyTransBySMId = new ArrayList<MatMonthlyTrans>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<MatPurReqDetail> matPurReqDetailsBySMId = new ArrayList<MatPurReqDetail>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<ReceivingDetail> receivingDetailsBySMId = new ArrayList<ReceivingDetail>();

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<SellInvDetail> sellInvDetailsBySMId = new ArrayList<SellInvDetail>();

    @ManyToOne
    @JoinColumn(name = "m_code", referencedColumnName = "m_code", nullable = false)
    private Material materialByMCode;

    @OneToMany(mappedBy = "subMaterialBySMId")
    private List<SupplyReqDetail> supplyReqDetailsBySMId = new ArrayList<SupplyReqDetail>();

}
