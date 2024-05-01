package com.example.muckja.domain.store.exception;

import com.example.muckja.global.error.CustomException;
import com.example.muckja.global.error.ErrorCode;

public class StoreExistException extends CustomException {
    public static final CustomException EXCEPTION = new StoreExistException();

    private StoreExistException(){
        super(ErrorCode.STORE_EXIST);
    }
}
