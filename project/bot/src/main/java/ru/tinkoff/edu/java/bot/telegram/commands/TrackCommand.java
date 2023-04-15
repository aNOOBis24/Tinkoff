package ru.tinkoff.edu.java.bot.telegram.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.dto.AddLinkRequest;
import ru.tinkoff.edu.java.bot.service.LinkService;

@Component
public class TrackCommand implements Command{
    private LinkService linkService;

    public TrackCommand(LinkService linkService) {
        this.linkService = linkService;
    }

    @Override
    public String command() {
        return "/track";
    }

    @Override
    public String script() {
        return "Начать отслеживать ссылку.";
    }

    @Override
    public SendMessage handle(Update update) {
        String message = update.message().text();
        if (message.charAt(0) == '/') return new SendMessage(update.message().chat().id(), "Введите ссылку");
        linkService.addLink(update.message().chat().id(), new AddLinkRequest(update.message().text()));
        return new SendMessage(update.message().chat().id(), "Ссылка отслеживается");
    }
}