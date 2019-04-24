package com.finance.warehouse.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.finance.warehouse.entity.audit.UserDateAudit;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "matDelReq", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "serial"
        })
})
public class MatDelReq extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "folder_num")
    private String folderNum;

    @NotBlank
    @Size(max = 20)
    @Column(name = "serial")
    private String serial;

    @NotNull
    @Column(name = "date")
    private Date date;

    /* @OneToMany(mappedBy = "matDelReq")
    private List<InternDelivery> internDeliveries = new ArrayList<InternDelivery>();

   @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    private Department departmentByDepId;*/

    @ManyToOne
    @JoinColumn(name = "applicant_emp_id", referencedColumnName = "id")
    private Employee applicant;

    @OneToMany(mappedBy = "matDelReq", cascade = CascadeType.ALL,fetch = FetchType.EAGER,
            orphanRemoval = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<MatDelReqDetail> matDelReqDetails = new ArrayList<MatDelReqDetail>();


    public void addDetail(MatDelReqDetail detail) {
        matDelReqDetails.add(detail);
        detail.setMatDelReq(this);
    }

}
