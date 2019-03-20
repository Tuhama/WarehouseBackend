package com.finance.warehouse.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import com.finance.warehouse.entity.audit.UserDateAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "contact")
public class Contact extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "name")
    @NotBlank
    @Size(max = 140)
    private String name;


    @OneToMany(mappedBy = "contact")
    private List<Entry> entries = new ArrayList<Entry>();

}
