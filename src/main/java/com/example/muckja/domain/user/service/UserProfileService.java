package com.example.muckja.domain.user.service;

import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.domain.review.presentation.dto.response.ReviewResponse;
import com.example.muckja.domain.user.domain.User;
import com.example.muckja.domain.user.facade.UserFacade;
import com.example.muckja.domain.user.presentation.dto.response.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserProfileService {
    private final UserFacade userFacade;

    @Transactional
    public UserProfileResponse execute(){
        User user = userFacade.getCurrentUser();

        List<Review> reviewList = user.getReview();
        List<ReviewResponse> reviews = reviewList.stream()
                .map(ReviewResponse::from).toList();

        return UserProfileResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .reviews(reviews)
                .build();
    }
}
