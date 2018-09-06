package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "auditTrail")
public class AuditTrail {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Basic
    @Column(name = "DateTime")
    private Timestamp dateTime;

    @Basic
    @Column(name = "Script")
    private String script;

    @Basic
    @Column(name = "User")
    private String user;

    @Basic
    @Column(name = "Action")
    private String action;

    @Basic
    @Column(name = "Table")
    private String table;

    @Basic
    @Column(name = "Field")
    private String field;

    @Basic
    @Column(name = "KeyValue")
    private String keyValue;

    @Basic
    @Column(name = "OldValue")
    private String oldValue;

    @Basic
    @Column(name = "NewValue")
    private String newValue;


}
