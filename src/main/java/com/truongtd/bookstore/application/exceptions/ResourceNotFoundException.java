package com.truongtd.bookstore.application.exceptions;

import com.truongtd.bookstore.application.services.Translator;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ResourceException {

    public ResourceNotFoundException() {
        super(HttpStatus.NOT_FOUND.value(), Translator.toLocale("error404"));
    }

    public ResourceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}
