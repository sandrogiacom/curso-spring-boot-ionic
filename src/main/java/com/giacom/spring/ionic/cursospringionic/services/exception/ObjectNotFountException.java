package com.giacom.spring.ionic.cursospringionic.services.exception;

public class ObjectNotFountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFountException(String message) {
        super(message);
    }

    public ObjectNotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
