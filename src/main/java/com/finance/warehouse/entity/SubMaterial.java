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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "min")
    private Integer min;


    @Column(name = "max")
    private Integer max;


    @Column(name = "name")
    private String name;


    @Column(name = "quantity")
    private Integer quantity;


    @Column(name = "note")
    private String note;

/*    @OneToMany(mappedBy = "subMaterialById")
    private List<Custody> custodiesById = new ArrayList<Custody>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<EntryDetail> entryDetailsById = new ArrayList<EntryDetail>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<ExternDeliveryDetail> externDeliveryDetailsById = new ArrayList<ExternDeliveryDetail>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<InternDeliveryDetail> internDeliveryDetailsById = new ArrayList<InternDeliveryDetail>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<InventoryDetail> inventoryDetailsById = new ArrayList<InventoryDetail>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<MatDelReqDetail> matDelReqDetailsById = new ArrayList<MatDelReqDetail>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<MatMonthlyTrans> matMonthlyTransById = new ArrayList<MatMonthlyTrans>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<MatPurReqDetail> matPurReqDetailsById = new ArrayList<MatPurReqDetail>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<ReceivingDetail> receivingDetailsById = new ArrayList<ReceivingDetail>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<SellInvDetail> sellInvDetailsById = new ArrayList<SellInvDetail>();

    @OneToMany(mappedBy = "subMaterialById")
    private List<SupplyReqDetail> supplyReqDetailsById = new ArrayList<SupplyReqDetail>();*/

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id", nullable = false)
    private Material material;
}
