package com.java.uioks.messApp.dto;

public class ErrorDto {

    private String message;

    public ErrorDto() {
    }

    public ErrorDto(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}