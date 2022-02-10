package com.truongtd.bookstore.api.response;

import com.truongtd.bookstore.application.services.Translator;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ErrorResponse extends ApiResponse {

    public ErrorResponse() {
        super(400, "Error");
    }

    public ErrorResponse(String message) {
        super(400, message);
    }

    public ErrorResponse(String message, Object data) {
        super(400, message, data);
    }

    public ErrorResponse(String message, List<FieldError> errors) {
        super(400, message, new ApiError(errors.stream().
                map(e -> {
                    Optional<String> code = Arrays.stream(e.getCodes()).filter(c -> Translator.toLocale(c) != c).findFirst();
                    return new Error(e.getField(), e.getRejectedValue(), Translator.toLocale(code.get(), e.getArguments()));
                }).collect(Collectors.toList())));
    }

    @Value
    @AllArgsConstructor
    public static class ApiError {
        List<Error> errors;
    }

    @Value
    @AllArgsConstructor
    public static class Error {
        private String field;
        private Object value;
        private String message;
    }
}
