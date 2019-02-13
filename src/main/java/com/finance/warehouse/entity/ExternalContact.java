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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "externalContact")
    private List<ExternDelivery> externDeliveries = new ArrayList<ExternDelivery>();

    @OneToMany(mappedBy = "externalContact")
    private List<SellInv> sellInvs = new ArrayList<SellInv>();

}
