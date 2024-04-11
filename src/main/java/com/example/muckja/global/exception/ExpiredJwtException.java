package com.example.muckja.global.exception;

import com.example.muckja.global.error.CustomException;
import com.example.muckja.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {
    public static final CustomException EXCEPTION = new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}