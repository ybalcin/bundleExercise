package com.bundle.exercise.infrastructure.crossCutting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUId = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
