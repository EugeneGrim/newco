package com.andreitop.newco.exceptions;

import org.springframework.http.HttpStatus;

public class ApiError {

    private String error;
    private String message;
    private HttpStatus httpStatus;

    public ApiError(String error, String message, HttpStatus httpStatus) {
        this.error = error;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
