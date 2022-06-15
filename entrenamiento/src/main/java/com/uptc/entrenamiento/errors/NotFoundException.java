package com.uptc.entrenamiento.errors;

public class NotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "";

    public NotFoundException(String detail) {
        super(DESCRIPTION + detail);
    }
}