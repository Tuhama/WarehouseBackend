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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "contact")
    private List<Entry> entries = new ArrayList<Entry>();

}
