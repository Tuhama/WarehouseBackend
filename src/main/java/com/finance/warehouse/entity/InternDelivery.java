package com.finance.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "internDelivery")
public class InternDelivery {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "folder_num")
    private String folderNum;

    @Basic
    @Column(name = "serial")
    private String serial;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "internDeliveryByIntenalDeliveryId")
    private Collection<Custody> custodiesById;

    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id", nullable = false)
    private Department departmentByDepId;

    @ManyToOne
    @JoinColumn(name = "mat_req_id", referencedColumnName = "id", nullable = false)
    private MatDelReq matDelReqByMatReqId;

    @ManyToOne
    @JoinColumn(name = "w_man_id", referencedColumnName = "id", nullable = false)
    private Employee employeeByWManId;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = false)
    private Employee employeeByReceiverId;

    @OneToMany(mappedBy = "internDeliveryByInternalDeliveryId")
    private List<InternDeliveryDetail> internDeliveryDetailsById = new ArrayList<InternDeliveryDetail>();

}
