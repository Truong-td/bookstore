package com.truongtd.bookstore.api.response;

import com.truongtd.bookstore.application.exceptions.ResourceException;
import com.truongtd.bookstore.application.services.Translator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ExceptionAdviceHandle {

    @Autowired
    private Translator translator;

    // Must enable webmvc in a configuration
    @ExceptionHandler(value = { NoHandlerFoundException.class })
    public ApiResponse handlePageNotFoundException(Exception e) {
        return new ApiResponse(HttpStatus.NOT_FOUND.value(), translator.toLocale("error404"), null);
    }

    @ExceptionHandler({ResourceException.class})
    public ApiResponse handleResourceException(ResourceException e) {
        return new ApiResponse(e.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler
    public ApiResponse internalServerError(Exception e) {
        log.error(String.format("Uncaught Exception : %s : %s ", e.getClass(), e.getMessage()), e);
        return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), translator.toLocale("error500"), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse validationForm(MethodArgumentNotValidException e) {
        return new ErrorResponse(translator.toLocale("error400"), e.getBindingResult().getFieldErrors());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ApiResponse validationUri(MethodArgumentTypeMismatchException e) {
        return handlePageNotFoundException(e);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class})
    public ApiResponse handleInvalidFormatException(Exception e) {
        return new ApiResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), translator.toLocale("error405"), null);
    }
}
