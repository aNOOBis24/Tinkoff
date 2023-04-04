package ru.tinkoff.edu.java.bot.dto.dto;

public record ApiErrorResponse(String description, String code, String exceptionName,
                               String exceptionMessage, String[] stacktrace) {
}
