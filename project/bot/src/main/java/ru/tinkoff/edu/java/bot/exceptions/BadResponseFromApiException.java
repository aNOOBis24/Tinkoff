package ru.tinkoff.edu.java.bot.exceptions;

public class BadResponseFromApiException extends RuntimeException {

    public BadResponseFromApiException() {
    }

    public BadResponseFromApiException(String message) {
        super(message);
    }
}
