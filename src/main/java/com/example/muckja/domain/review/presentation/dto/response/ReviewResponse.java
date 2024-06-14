package com.example.muckja.domain.review.presentation.dto.response;

import com.example.muckja.domain.review.domain.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponse {
    private final Long id;

    private final Integer rating;

    private final String content;

    private final Integer taste;

    private final Integer amount;

    private final Integer kindness;


    public static ReviewResponse from(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .taste(review.getTaste())
                .amount(review.getAmount())
                .kindness(review.getKindness())
                .build();
    }
}
