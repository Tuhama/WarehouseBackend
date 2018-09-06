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
    @GeneratedValue
    @Column(name = "m_code")
    private int mCode;

    @Basic
    @Column(name = "m_name")
    private String mName;

    @Basic
    @Column(name = "m_unit")
    private int mUnit;

    @Basic
    @Column(name = "m_type")
    private String mType;

    @Basic
    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "materialByMCode")
    private List<SubMaterial> subMaterialsByMCode = new ArrayList<SubMaterial>();

}
