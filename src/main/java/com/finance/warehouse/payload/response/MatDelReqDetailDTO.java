package com.finance.warehouse.payload.response;


import com.finance.warehouse.entity.SubMaterial;
import lombok.Data;

import java.sql.Date;


@Data
public class MatDelReqDetailDTO {

    private Long id;

    private String description;


    private int amount;


    private String purpose;


    private Integer prevDellAmount;


    private Date prevDellDate;


    private Integer allowedAmount;


    private String note;


    private SubMaterial subMaterial;


}
