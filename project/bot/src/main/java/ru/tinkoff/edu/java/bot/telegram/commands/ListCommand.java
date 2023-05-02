package ru.tinkoff.edu.java.bot.telegram.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.model.Link;

import java.util.List;

@Component
public class ListCommand implements Command{
    private final LinkService linkService;

    public ListCommand(LinkService linkService) {
        this.linkService = linkService;
    }


    @Override
    public String command() {
        return "/list";
    }

    @Override
    public String script() {
        return "Cписок отслеживаемых ссылок";
    }



    @Override
    public SendMessage handle(Update update) {
        List<Link> listLinkResponse = linkService.getLinks(update.message().chat().id());
        if (listLinkResponse == null || listLinkResponse.size() == 0) return new SendMessage(update.message().chat().id(), "Нет отслеживаемых ссылок");
        var answer = new StringBuilder();
        answer.append("Список отслеживаемых ссылок:\n");
        for (int i = 0; i < listLinkResponse.size(); i++) {
            answer.append(listLinkResponse.get(i).getUrl()).append("\n");
        }
        return new SendMessage(update.message().chat().id(), answer.toString());
    }
}
