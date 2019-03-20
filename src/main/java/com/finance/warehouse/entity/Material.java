package com.finance.warehouse.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "material")
public class Material {

/*
    public Material(String name,Unit unit,String type,String note) {
        this.name = name;
        this.unit = unit;
        this.type = type;
        this.note = note;
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "name")
    private String name;


/*    @Column(name = "unit")
    private int unit;*/

    @NonNull
    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    private Unit unit;

    @NonNull
    @Column(name = "type")
    private String type;


    @Column(name = "note")
    private String note;

/*    @OneToMany(mappedBy = "material")
    private List<SubMaterial> subMaterials = new ArrayList<SubMaterial>();*/

}
