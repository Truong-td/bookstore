package com.truongtd.bookstore.application.exceptions;

import com.truongtd.bookstore.application.services.Translator;
import org.springframework.http.HttpStatus;

public class ResourceConflictException extends ResourceException {

    public ResourceConflictException() {
        super(HttpStatus.CONFLICT.value(), Translator.toLocale("error409"));
    }

    public ResourceConflictException(String message) {
        super(HttpStatus.CONFLICT.value(), message);
    }
}
