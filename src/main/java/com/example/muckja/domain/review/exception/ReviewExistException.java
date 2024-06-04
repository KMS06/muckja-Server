package com.example.muckja.domain.review.exception;

import com.example.muckja.global.error.CustomException;
import com.example.muckja.global.error.ErrorCode;

public class ReviewExistException extends CustomException {
    public static final CustomException EXCEPTION = new ReviewExistException();

    private ReviewExistException(){
        super(ErrorCode.REVIEW_EXIST);
    }
}
