package com.bundle.exercise.infrastructure.crossCutting.exception;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUId = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
