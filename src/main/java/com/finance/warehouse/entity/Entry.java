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
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "folder_num")
    private String folderNum;


    @Basic
    @Column(name = "serial")
    private String serial;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "bill_date")
    private Date billDate;

    @Basic
    @Column(name = "bill_num")
    private String billNum;

    @Basic
    @Column(name = "entry_type")
    private byte entryType;

    @Basic
    @Column(name = "w_man_id")
    private Integer wManId;

    @Basic
    @Column(name = "deliverer")
    private String deliverer;

    @Basic
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
