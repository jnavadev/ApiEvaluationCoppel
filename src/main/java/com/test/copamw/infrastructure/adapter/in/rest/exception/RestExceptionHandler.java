package com.test.copamw.infrastructure.adapter.in.rest.exception;

import com.test.copamw.application.exception.ServiceException;
import com.test.copamw.infrastructure.adapter.in.rest.dto.ErrorResponseDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.test.copamw.constants.GlobalConstants.*;

/**
 * Handles application exceptions and translates them into
 * consistent REST error responses.
 *
 * <p>This class acts as the centralized exception handling mechanism
 * for the inbound REST adapter.</p>
 */
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * Handles validation errors caused by invalid request parameters.
     *
     * @param exception validation exception
     * @return HTTP 400 response with a standardized error body
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleConstraintViolation(
            ConstraintViolationException exception) {

        ErrorResponseDto errorResponse = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.value(),
                BAD_REQUEST,
                SEARCH_QUERY_EMPTY);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponseDto> handleMissingServletRequestParameter(
            MissingServletRequestParameterException exception) {

        ErrorResponseDto errorResponse = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.value(),
                BAD_REQUEST,
                exception.getParameterName() + " not empty");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponseDto> handleTvMazeServiceException(
            ServiceException exception) {

        ErrorResponseDto errorResponse = new ErrorResponseDto(
                HttpStatus.BAD_GATEWAY.value(),
                BAD_GATEWAY,
                exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(errorResponse);
    }
}
