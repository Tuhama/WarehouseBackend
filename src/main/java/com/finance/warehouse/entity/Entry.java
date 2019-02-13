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
@Table(name = "entry")
public class Entry {

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


    @Column(name = "bill_date")
    private Date billDate;


    @Column(name = "bill_num")
    private String billNum;


    @Column(name = "entry_type")
    private byte entryType;


    @Column(name = "w_man_id")
    private Integer wManId;


    @Column(name = "deliverer")
    private String deliverer;


    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "entry")
    private List<Custody> custodies = new ArrayList<Custody>();

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private Employee employee;

    @OneToMany(mappedBy = "entry")
    private List<EntryDetail> entryDetails = new ArrayList<EntryDetail>();

}
