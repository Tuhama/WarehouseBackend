package com.finance.warehouse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;


    @Basic
    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "contactByContactId")
    private List<Entry> entriesById = new ArrayList<Entry>();

}
