package com.truongtd.bookstore.application.exceptions;

public class ResourceException extends RuntimeException {

    private int code;
    private String message;

    /**
     * Contructor input code and messages exception
     * @param code
     * @param message
     */
    public ResourceException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * Contructor input exception code
     * @param exceptionCode
     */
    public ResourceException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
