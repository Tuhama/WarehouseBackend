package com.finance.warehouse.service;

import com.finance.warehouse.entity.MatDelReq;
import com.finance.warehouse.entity.MatDelReqDetail;
import com.finance.warehouse.entity.User;
import com.finance.warehouse.exception.BadRequestException;
import com.finance.warehouse.exception.ResourceNotFoundException;
import com.finance.warehouse.payload.PagedResponse;
import com.finance.warehouse.payload.request.MatDelReqDTO;
import com.finance.warehouse.repository.MatDelReqRepository;
import com.finance.warehouse.repository.UserRepository;
import com.finance.warehouse.security.UserPrincipal;
import com.finance.warehouse.util.AppConstants;
import com.finance.warehouse.util.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

@Service
public class MatDelReqService {
    @Autowired
    private MatDelReqRepository matDelReqRepository;

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(MatDelReqService.class);

    public PagedResponse<com.finance.warehouse.payload.response.MatDelReqDTO> getAllMatDelReq(UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        // Retrieve Polls
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<MatDelReq> polls = matDelReqRepository.findAll(pageable);

        if (polls.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), polls.getNumber(),
                    polls.getSize(), polls.getTotalElements(), polls.getTotalPages(), polls.isLast());
        }

        // Map Polls to PollResponses containing vote counts and poll creator details
        List<Long> pollIds = polls.map(MatDelReq::getId).getContent();


        Map<Long, User> creatorMap = getPollCreatorMap(polls.getContent());

        List<com.finance.warehouse.payload.response.MatDelReqDTO> pollResponses = polls.map(poll -> {
            return ModelMapper.mapMatDelReqToResponse(poll,
                    creatorMap.get(poll.getCreatedBy()));
        }).getContent();

        return new PagedResponse<>(pollResponses, polls.getNumber(),
                polls.getSize(), polls.getTotalElements(), polls.getTotalPages(), polls.isLast());
    }

    public PagedResponse<com.finance.warehouse.payload.response.MatDelReqDTO> getMatDelReqCreatedBy(String username, UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        // Retrieve all  created by the given username
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<MatDelReq> matDelReqs = matDelReqRepository.findByCreatedBy(user.getId(), pageable);

        if (matDelReqs.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), matDelReqs.getNumber(),
                    matDelReqs.getSize(), matDelReqs.getTotalElements(), matDelReqs.getTotalPages(), matDelReqs.isLast());
        }

        List<com.finance.warehouse.payload.response.MatDelReqDTO> responses = matDelReqs.map(response -> {
            return ModelMapper.mapMatDelReqToResponse(response,
                    user);
        }).getContent();

        return new PagedResponse<>(responses, matDelReqs.getNumber(),
                matDelReqs.getSize(), matDelReqs.getTotalElements(), matDelReqs.getTotalPages(), matDelReqs.isLast());
    }



    public MatDelReq createMatDelReq(MatDelReqDTO request) {

        MatDelReq poll = new MatDelReq();
        poll.setApplicant(request.getApplicant());
        poll.setDate(request.getDate());
        poll.setFolderNum(request.getFolderNum());
        poll.setSerial(request.getSerial());
        //poll.set(request.getApplicant());

        request.getMatDelReqDetails().forEach(detailRequest -> {
            poll.addDetail(new MatDelReqDetail(detailRequest));
        });


        return matDelReqRepository.save(poll);
    }

    public com.finance.warehouse.payload.response.MatDelReqDTO getMatDelReqById(Long pollId, UserPrincipal currentUser) {
        MatDelReq poll = matDelReqRepository
                .findById(pollId).orElseThrow(
                () -> new ResourceNotFoundException("Poll", "id", pollId));


        // Retrieve poll creator details
        User creator = userRepository.findById(poll.getCreatedBy())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", poll.getCreatedBy()));



        return ModelMapper.mapMatDelReqToResponse(poll, creator);
    }


    private void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if (size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }



    Map<Long, User> getPollCreatorMap(List<MatDelReq> polls) {
        // Get Poll Creator details of the given list of polls
        List<Long> creatorIds = polls.stream()
                .map(MatDelReq::getCreatedBy)
                .distinct()
                .collect(Collectors.toList());

        List<User> creators = userRepository.findByIdIn(creatorIds);
        Map<Long, User> creatorMap = creators.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        return creatorMap;
    }


}
