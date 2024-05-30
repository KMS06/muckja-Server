package com.example.muckja.domain.review.service;

import com.example.muckja.domain.review.facade.ReviewFacade;
import com.example.muckja.domain.review.presentation.dto.response.QueryReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryReviewService {
    private final ReviewFacade reviewFacade;

    @Transactional
    public List<QueryReviewResponse> execute(Long storeId){
        List<QueryReviewResponse> reviewList = reviewFacade.findByStoreId(storeId).stream()
                .map(QueryReviewResponse::from)
                .toList();

        return reviewList;
    }
}
