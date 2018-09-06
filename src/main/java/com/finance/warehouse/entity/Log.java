package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "process_type")
    private Integer processType;

    @Basic
    @Column(name = "record_id")
    private Integer recordId;

    @Basic
    @Column(name = "user_id")
    private Integer userId;

    @Basic
    @Column(name = "process_date")
    private Timestamp processDate;

}
