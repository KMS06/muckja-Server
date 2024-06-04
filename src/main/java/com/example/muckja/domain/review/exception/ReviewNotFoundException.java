package com.example.muckja.domain.review.exception;

import com.example.muckja.global.error.CustomException;
import com.example.muckja.global.error.ErrorCode;

public class ReviewNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new ReviewNotFoundException();

    private ReviewNotFoundException(){
        super(ErrorCode.REVIEW_NOT_FOUND);
    }
}
