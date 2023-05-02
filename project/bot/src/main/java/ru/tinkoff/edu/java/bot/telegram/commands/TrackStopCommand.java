package ru.tinkoff.edu.java.bot.telegram.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

@Component
public class TrackStopCommand implements Command{
    private final LinkService linkService;

    public TrackStopCommand(LinkService linkService) {
        this.linkService = linkService;
    }

    @Override
    public String command() {
        return "/untrack";
    }

    @Override
    public String script() {
        return "Перестать отслеживать ссылку.";
    }

    @Override
    public SendMessage handle(Update update) {
        String message = update.message().text();
        if (message.charAt(0) == '/') return new SendMessage(update.message().chat().id(), "Введите ссылку");
        linkService.deleteLink(update.message().chat().id(), new RemoveLinkRequest(update.message().text()));
        return new SendMessage(update.message().chat().id(), "Ссылка отслеживается");
    }
}
