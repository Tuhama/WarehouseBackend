package com.finance.warehouse.payload.response;

import com.finance.warehouse.entity.Employee;
import com.finance.warehouse.payload.UserSummary;
import lombok.Data;

import java.time.Instant;
import java.sql.Date;
import java.util.List;

@Data
public class MatDelReqDTO {

    private Long id;
    private String folderNum;


    private String serial;


    private Date date;

    private Employee applicant;

    private List<MatDelReqDetailDTO> matDelReqDetails;


    private UserSummary createdBy;
    private Instant creationDateTime;


    //private Instant expirationDateTime;


/*    public List<MatDelReqDetailDTO> getDetails() {
        return matDelReqDetails;
    }

    public void setDetails(List<MatDelReqDetailDTO> matDelReqDetails) {
        this.matDelReqDetails = matDelReqDetails;
    }*/
}
