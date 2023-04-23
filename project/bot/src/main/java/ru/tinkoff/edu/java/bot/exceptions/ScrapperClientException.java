package ru.tinkoff.edu.java.bot.exceptions;

public class ScrapperClientException extends RuntimeException{

    public ScrapperClientException() {
    }

    public ScrapperClientException(String message) {
        super(message);
    }
}