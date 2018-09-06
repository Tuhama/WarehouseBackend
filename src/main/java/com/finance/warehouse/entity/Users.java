package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "pw")
    private String pw;

    @Basic
    @Column(name = "u_level")
    private int uLevel;
}
