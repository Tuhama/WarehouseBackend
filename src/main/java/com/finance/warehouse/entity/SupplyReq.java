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
@Table(name = "supplyReq")
public class SupplyReq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "date")
    private Date date;


    @Column(name = "w_man")
    private int wMan;

    @OneToMany(mappedBy = "supplyReq")
    private List<SupplyReqDetail> supplyReqDetails= new ArrayList<SupplyReqDetail>();

}
