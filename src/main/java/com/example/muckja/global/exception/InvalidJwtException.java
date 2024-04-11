package com.example.muckja.global.exception;

import com.example.muckja.global.error.CustomException;
import com.example.muckja.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
