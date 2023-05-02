package ru.tinkoff.edu.java.bot.telegram.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

@Component
public class StartCommand implements Command{
    private ChatService chatService;

    public StartCommand(ChatService chatService) {
        this.chatService = chatService;
    }

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String script() {
        return "Старт бота";
    }

    @Override
    public SendMessage handle(Update update) {
        chatService.registerChat(update.message().chat().id());
        return new SendMessage(update.message().chat().id(), "Введите команду /help");
    }
}
