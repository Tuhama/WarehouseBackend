package com.finance.warehouse.payload.request;

import com.finance.warehouse.entity.Employee;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class MatDelReqDTO {


    private String folderNum;


    private String serial;


    private Date date;

    private Employee applicant;

    private List<MatDelReqDetailDTO> matDelReqDetails;

/*    public List<MatDelReqDetailDTO> getDetails() {
        return matDelReqDetails;
    }

    public void setDetails(List<MatDelReqDetailDTO> matDelReqDetails) {
        this.matDelReqDetails = matDelReqDetails;
    }*/
}
