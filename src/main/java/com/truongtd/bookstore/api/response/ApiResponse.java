package com.truongtd.bookstore.api.response;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ApiResponse extends ResponseEntity<ApiResponse.Payload> {

    public ApiResponse(int code, String message) {
        super(new Payload(code, message, null), HttpStatus.OK);
    }

    public ApiResponse(int code, String message, Object data) {
        super(new Payload(code, message, data), HttpStatus.OK);
    }

    @Value
    @AllArgsConstructor
    public static class Payload {
        private int code;
        private String message;
        private Object data;
    }
}
