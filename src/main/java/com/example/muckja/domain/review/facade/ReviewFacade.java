package com.example.muckja.domain.review.facade;

import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.domain.review.domain.exception.ReviewExistException;
import com.example.muckja.domain.review.domain.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ReviewFacade {
    private final ReviewRepository reviewRepository;
    public void checkReviewExist(Long userId, Long storeId){
        Optional<Review> review = reviewRepository.findByUserIdAndStoreId(userId, storeId);
        if(review.isPresent()){
            throw ReviewExistException.EXCEPTION;
        }
    }

    public List<Review> findByStoreId(Long storeId){
        List<Review> reviewList = reviewRepository.findByStoreId(storeId);
        return reviewList;
    }
}
