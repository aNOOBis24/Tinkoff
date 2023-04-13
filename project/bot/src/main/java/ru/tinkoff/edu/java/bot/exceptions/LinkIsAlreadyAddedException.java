package ru.tinkoff.edu.java.bot.exceptions;

public class LinkIsAlreadyAddedException extends RuntimeException {


    public LinkIsAlreadyAddedException(String message) {
        super(message);
    }

    public LinkIsAlreadyAddedException() {
    }
}