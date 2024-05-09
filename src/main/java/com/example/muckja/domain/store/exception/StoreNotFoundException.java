package com.example.muckja.domain.store.exception;

import com.example.muckja.global.error.CustomException;
import com.example.muckja.global.error.ErrorCode;

public class StoreNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new StoreNotFoundException();

    private StoreNotFoundException(){
        super(ErrorCode.STORE_NOT_FOUND);
    }
}
