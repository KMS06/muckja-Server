package com.example.muckja.domain.review.presentation.dto.response;

import com.example.muckja.domain.review.domain.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryReviewResponse {
    private final Integer rating;

    private final String content;

    private final Integer taste;

    private final Integer amount;

    private final Integer kindness;


    public static QueryReviewResponse from(Review review){
        return QueryReviewResponse.builder()
                .rating(review.getRating())
                .content(review.getContent())
                .taste(review.getTaste())
                .amount(review.getAmount())
                .kindness(review.getKindness())
                .build();
    }
}
