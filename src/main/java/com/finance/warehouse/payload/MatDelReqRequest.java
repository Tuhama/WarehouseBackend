package com.finance.warehouse.payload;

import com.finance.warehouse.entity.Employee;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MatDelReqRequest {


    private String folderNum;


    private String serial;


    private Date date;

    private Employee applicant;

    private List<MatDelReqDetailRequest> matDelReqDetails;

    public List<MatDelReqDetailRequest> getDetails() {
        return matDelReqDetails;
    }

    public void setDetails(List<MatDelReqDetailRequest> matDelReqDetails) {
        this.matDelReqDetails = matDelReqDetails;
    }
}
