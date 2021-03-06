package com.finance.warehouse.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.finance.warehouse.payload.request.MatDelReqDetailDTO;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "matDelReqDetail")
public class MatDelReqDetail {


public MatDelReqDetail(MatDelReqDetailDTO detailRequest){
    this.description = detailRequest.getDescription();
    this.amount = detailRequest.getAmount();
    this.purpose = detailRequest.getPurpose();
    this.prevDellAmount = detailRequest.getPrevDellAmount();
    this.prevDellDate = detailRequest.getPrevDellDate();
    this.allowedAmount = detailRequest.getAllowedAmount();
    this.note = detailRequest.getNote();
    this.subMaterial = detailRequest.getSubMaterial();
}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "description")
    private String description;


    @Column(name = "amount")
    private int amount;


    @Column(name = "purpose")
    private String purpose;


    @Column(name = "prev_dell_amount")
    private Integer prevDellAmount;


    @Column(name = "prev_dell_date")
    private Date prevDellDate;


    @Column(name = "allowed_amount")
    private Integer allowedAmount;


    @Column(name = "note")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "mat_req_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private MatDelReq matDelReq;

    @ManyToOne
    @JoinColumn(name = "s_m_id", referencedColumnName = "id", nullable = false)
    private SubMaterial subMaterial;


    public void setMatDelReq(MatDelReq matDelReq) {
        this.matDelReq = matDelReq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatDelReqDetail choice = (MatDelReqDetail) o;
        return Objects.equals(id, choice.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
