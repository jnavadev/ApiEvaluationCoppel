package com.test.copamw.application.exception;

/**
 * Exception thrown when an external service cannot be accessed
 * or returns an error response.
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
