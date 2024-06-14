package com.example.muckja.domain.user.presentation.dto.response;

import com.example.muckja.domain.review.presentation.dto.response.ReviewResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserProfileResponse {

    private final String email;

    private final String name;

    private final List<ReviewResponse> reviews;
}
