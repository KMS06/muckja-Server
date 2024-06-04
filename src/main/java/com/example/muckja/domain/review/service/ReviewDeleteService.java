package com.example.muckja.domain.review.service;

import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.domain.review.domain.repository.ReviewRepository;
import com.example.muckja.domain.review.facade.ReviewFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewDeleteService {
    private final ReviewFacade reviewFacade;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void execute(Long reviewId){
        Review review = reviewFacade.findById(reviewId);

        reviewRepository.delete(review);

        reviewFacade.storeRating(review.getStore());
    }
}
