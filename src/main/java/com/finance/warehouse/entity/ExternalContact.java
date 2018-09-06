package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "externalContact")
public class ExternalContact {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "externalContactByExtContactId")
    private List<ExternDelivery> externDeliveriesById = new ArrayList<ExternDelivery>();

    @OneToMany(mappedBy = "externalContactByExtContactId")
    private List<SellInv> sellInvsById = new ArrayList<SellInv>();

}
