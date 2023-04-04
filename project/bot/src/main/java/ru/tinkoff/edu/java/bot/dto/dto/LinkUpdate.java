package ru.tinkoff.edu.java.bot.dto.dto;

public record LinkUpdate(Long id, String url, String description, Long[] tgChatIds) {
}