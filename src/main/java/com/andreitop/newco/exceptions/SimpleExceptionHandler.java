package com.andreitop.newco.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SimpleExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers,
                                                                  final HttpStatus status,
                                                                  final WebRequest request) {
        ApiError apiError = new ApiError(ex.getMessage(), ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,
                                                                      final WebRequest request) {

        ApiError apiError = new ApiError(ex.getMessage(), ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ TripNotFoundException.class })
    protected ResponseEntity<Object> handleTripNotFound(final TripNotFoundException ex,
                                                        final WebRequest request) {

        ApiError apiError = new ApiError(ex.getMessage(), ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ NullPointerException.class })
    protected ResponseEntity<Object> handleNullPointerException(final NullPointerException ex,
                                                                final WebRequest request) {

        ApiError apiError = new ApiError(ex.getMessage(), ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
