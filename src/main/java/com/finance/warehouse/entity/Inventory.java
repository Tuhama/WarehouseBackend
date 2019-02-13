package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "folder_num")
    private String folderNum;


    @Column(name = "serial")
    private String serial;


    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "inventory")
    private List<InventoryDetail> inventoryDetails = new ArrayList<InventoryDetail>();

}
