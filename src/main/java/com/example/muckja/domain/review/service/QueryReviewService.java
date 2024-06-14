package com.example.muckja.domain.review.service;

import com.example.muckja.domain.review.facade.ReviewFacade;
import com.example.muckja.domain.review.presentation.dto.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryReviewService {
    private final ReviewFacade reviewFacade;

    @Transactional
    public List<ReviewResponse> execute(Long storeId){
        List<ReviewResponse> reviewList = reviewFacade.findByStoreId(storeId).stream()
                .map(ReviewResponse::from)
                .toList();

        return reviewList;
    }
}
