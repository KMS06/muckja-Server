package com.example.muckja.domain.user.exception;

import com.example.muckja.global.error.CustomException;
import com.example.muckja.global.error.ErrorCode;

public class UserExistException extends CustomException {
    public static final CustomException EXCEPTION = new UserExistException();

    private UserExistException(){
        super(ErrorCode.USER_EXIST);
    }
}
