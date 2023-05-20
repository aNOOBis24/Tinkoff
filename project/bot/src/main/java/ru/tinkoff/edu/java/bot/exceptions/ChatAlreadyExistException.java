package ru.tinkoff.edu.java.bot.exceptions;

public class ChatAlreadyExistException extends RuntimeException {

    public ChatAlreadyExistException() {
    }

    public ChatAlreadyExistException(String message) {
        super(message);
    }
}