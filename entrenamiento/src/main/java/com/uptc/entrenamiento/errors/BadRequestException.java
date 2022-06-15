package com.uptc.entrenamiento.errors;

public class BadRequestException extends RuntimeException {

    private static final String DESCRIPTION = "";

    public BadRequestException(String detail) {
        super(DESCRIPTION + detail);
    }
}
