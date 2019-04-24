package com.finance.warehouse.util;


import com.finance.warehouse.entity.MatDelReq;
import com.finance.warehouse.entity.User;
import com.finance.warehouse.payload.UserSummary;
import com.finance.warehouse.payload.response.MatDelReqDTO;
import com.finance.warehouse.payload.response.MatDelReqDetailDTO;


import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelMapper {



    public static MatDelReqDTO mapMatDelReqToResponse(MatDelReq matDelReq, User creator) {
        MatDelReqDTO response = new MatDelReqDTO();
        response.setId(matDelReq.getId());
        response.setApplicant(matDelReq.getApplicant());
        response.setDate(matDelReq.getDate());
        response.setFolderNum(matDelReq.getFolderNum());
        response.setSerial(matDelReq.getSerial());

        response.setCreationDateTime(matDelReq.getCreatedAt());

        List<MatDelReqDetailDTO> details = matDelReq.getMatDelReqDetails().stream().map(choice -> {
            MatDelReqDetailDTO detail = new MatDelReqDetailDTO();
            detail.setId(choice.getId());
            detail.setAllowedAmount(choice.getAllowedAmount());
            detail.setAmount(choice.getAmount());
            detail.setDescription(choice.getDescription());
            detail.setNote(choice.getNote());
            detail.setPrevDellAmount(choice.getPrevDellAmount());
            detail.setPrevDellDate(choice.getPrevDellDate());
            detail.setPurpose(choice.getPurpose());
            detail.setSubMaterial(choice.getSubMaterial());

            return detail;
        }).collect(Collectors.toList());

        response.setMatDelReqDetails(details);
        UserSummary creatorSummary = new UserSummary(creator.getId(), creator.getUsername(), creator.getName());
        response.setCreatedBy(creatorSummary);

        return response;
    }

}
