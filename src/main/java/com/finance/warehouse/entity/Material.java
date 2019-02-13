package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "material")
public class Material {
    @Id
    //@GeneratedValue
    @Column(name = "id")
    private int id;///رمز المادة

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "unit")
    private int unit;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "note")
    private String note;

/*    @OneToMany(mappedBy = "material")
    private List<SubMaterial> subMaterials = new ArrayList<SubMaterial>();*/

}
