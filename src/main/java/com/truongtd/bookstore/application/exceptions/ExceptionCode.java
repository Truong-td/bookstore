package com.truongtd.bookstore.application.exceptions;

import com.truongtd.bookstore.application.services.Translator;

public enum ExceptionCode {
    AUTH_INVALID_AUTHENTICATION(400, "authentication.error400"),
    AUTH_INVALID_TOKEN(401, "authentication.error401"),
    AUTH_TOKEN_EXPIRED(498, "authentication.error498"),
    DELETE_COMPANY_ERROR(611, "error611"),
    ADMIN_USERNAME_EXIST(612, "error612"),
    DRIVER_USERNAME_EXIST(613, "error613"),
    DRIVE_RECORDER_NOT_FOUND(614, "error614"),
    COMPANY_NOT_FOUND(615, "error615"),
    CURRENT_PASSWORD_NOT_MATCH(616, "error616");

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return Translator.toLocale(message);
    }
}
