package com.finance.warehouse.service;

import com.finance.warehouse.entity.MatDelReq;
import com.finance.warehouse.entity.MatDelReqDetail;
import com.finance.warehouse.payload.MatDelReqRequest;
import com.finance.warehouse.repository.MatDelReqDetailRepository;
import com.finance.warehouse.repository.MatDelReqRepository;
import com.finance.warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class MatDelReqService {
    @Autowired
    private MatDelReqRepository matDelReqRepository;

    @Autowired
    private MatDelReqDetailRepository matDelReqDetailRepository;

    /*@Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(MatDelReqService.class);*/

    public MatDelReq createMatDelReq(MatDelReqRequest matDelRequest) {
        MatDelReq matDelReq  = new MatDelReq();


        matDelRequest.getDetails().forEach(detailRequest -> {
            matDelReq.addDetail( new MatDelReqDetail( detailRequest));
        });


        return matDelReqRepository.save(matDelReq);
    }


}
