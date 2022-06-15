package com.uptc.entrenamiento.config;


import com.uptc.entrenamiento.errors.BadRequestException;
import com.uptc.entrenamiento.errors.ErrorMessage;
import com.uptc.entrenamiento.errors.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            NotFoundException.class

    })
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception exception) {
        return new ErrorMessage(exception, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.dao.DuplicateKeyException.class,
            org.springframework.web.bind.support.WebExchangeBindException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class,
            org.springframework.web.server.ServerWebInputException.class
    })
    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        return new ErrorMessage(exception, HttpStatus.BAD_REQUEST.value());
    }
}
