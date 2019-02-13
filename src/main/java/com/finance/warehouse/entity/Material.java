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


    @Column(name = "name")
    private String name;


    @Column(name = "unit")
    private int unit;


    @Column(name = "type")
    private String type;


    @Column(name = "note")
    private String note;

/*    @OneToMany(mappedBy = "material")
    private List<SubMaterial> subMaterials = new ArrayList<SubMaterial>();*/

}
