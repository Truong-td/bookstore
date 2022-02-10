package com.truongtd.bookstore.api.response;

import com.truongtd.bookstore.application.services.Translator;

import java.util.List;

public class SuccessResponse extends ApiResponse {

    public SuccessResponse() {
        super(200, Translator.toLocale("success"));
    }

    public SuccessResponse(Object data) {
        super(200, Translator.toLocale("success"), data);
    }

}
