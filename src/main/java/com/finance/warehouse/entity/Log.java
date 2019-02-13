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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "process_type")
    private Integer processType;


    @Column(name = "record_id")
    private Integer recordId;


    @Column(name = "user_id")
    private Integer userId;


    @Column(name = "process_date")
    private Timestamp processDate;

}
