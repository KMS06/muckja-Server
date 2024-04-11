package com.example.muckja.global.exception;

import com.example.muckja.global.error.CustomException;
import com.example.muckja.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final CustomException EXCEPTION = new SignatureJwtException();

    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }
}
