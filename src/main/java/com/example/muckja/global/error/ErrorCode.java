package com.example.muckja.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    USER_NOT_FOUND(404, "User Not Found"),
    STORE_NOT_FOUND(404, "Store Not Found"),
    REVIEW_NOT_FOUND(404, "Review Not Found"),

    USER_EXIST(409, "User Exist"),
    STORE_EXIST(409,"Store Exist"),
    REVIEW_EXIST(409, "Review Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}