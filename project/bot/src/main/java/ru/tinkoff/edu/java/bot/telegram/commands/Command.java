package ru.tinkoff.edu.java.bot.telegram.commands;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public interface Command {
    String command();

    String script();

    SendMessage handle(Update update);

    default boolean supports(Update update) {
        return false;
    }

    default BotCommand ApiCommand() {
        return new BotCommand(command(), script());
    }
}
