package com.example.muckja.domain.review.facade;

import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.domain.review.exception.ReviewExistException;
import com.example.muckja.domain.review.domain.repository.ReviewRepository;
import com.example.muckja.domain.review.exception.ReviewNotFoundException;
import com.example.muckja.domain.store.domain.Store;
import com.example.muckja.domain.store.domain.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ReviewFacade {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    public void checkReviewExist(Long userId, Long storeId){
        Optional<Review> review = reviewRepository.findByUserIdAndStoreId(userId, storeId);
        if(review.isPresent()){
            throw ReviewExistException.EXCEPTION;
        }
    }

    public Review findById(Long reviewId){
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> ReviewNotFoundException.EXCEPTION);
    }

    public List<Review> findByStoreId(Long storeId){
        List<Review> reviewList = reviewRepository.findByStoreId(storeId);
        return reviewList;
    }

    public void storeRating(Store store){
        List<Review> reviews = store.getReview();

        int rating = 0;
        int amount = 0;
        int taste = 0;
        int kindness = 0;

        for(Review review : reviews){
            rating += review.getRating();
            amount += review.getAmount();
            taste += review.getTaste();
            kindness += review.getKindness();
        }

        BigDecimal size = new BigDecimal(reviews.size());

        BigDecimal ratingB = new BigDecimal(rating);
        ratingB = ratingB.divide(size, 1, RoundingMode.HALF_UP);

        BigDecimal amountB = new BigDecimal(amount);
        amountB = amountB.divide(size, 1, RoundingMode.HALF_UP);

        BigDecimal tasteB = new BigDecimal(taste);
        tasteB = tasteB.divide(size, 1, RoundingMode.HALF_UP);

        BigDecimal kindnessB = new BigDecimal(kindness);
        kindnessB = kindnessB.divide(size, 1, RoundingMode.HALF_UP);

        store.update(ratingB, tasteB, amountB, kindnessB);

        storeRepository.save(store);
    }
}
