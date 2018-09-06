package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

}
