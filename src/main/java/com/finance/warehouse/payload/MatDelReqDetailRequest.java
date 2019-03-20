package com.finance.warehouse.payload;


import com.finance.warehouse.entity.SubMaterial;
import lombok.Data;
import java.sql.Date;


@Data
public class MatDelReqDetailRequest {

    private String description;


    private int amount;


    private String purpose;


    private Integer prevDellAmount;


    private Date prevDellDate;


    private Integer allowedAmount;


    private String note;


    private SubMaterial subMaterial;


}
