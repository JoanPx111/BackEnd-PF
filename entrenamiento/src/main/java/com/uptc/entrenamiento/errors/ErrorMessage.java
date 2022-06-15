package com.uptc.entrenamiento.errors;


public class ErrorMessage
{
    private String title;
    private Integer code;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(Exception exception, Integer code ) {
        this.title = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "title='" + title + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
