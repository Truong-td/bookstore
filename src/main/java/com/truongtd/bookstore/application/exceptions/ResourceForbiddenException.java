package com.truongtd.bookstore.application.exceptions;

import com.truongtd.bookstore.application.services.Translator;
import org.springframework.http.HttpStatus;

public class ResourceForbiddenException extends ResourceException {
    public ResourceForbiddenException() {
        super(HttpStatus.FORBIDDEN.value(), Translator.toLocale("error403"));
    }

    public ResourceForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN.value(), message);
    }
}
