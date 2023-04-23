package ru.tinkoff.edu.java.bot.service;


import com.pengrad.telegrambot.TelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.bot.dto.LinkUpdate;
import ru.tinkoff.edu.java.bot.telegram.bot.Bot;

@Service
@Slf4j
public class UpdateServiceImpl implements UpdateService{

    private final Bot bot;

    public UpdateServiceImpl(Bot bot) {
        this.bot = bot;
    }

    public void updateLink(LinkUpdate linkUpdate) {
        log.info("updateLink() method invocation in UpdateServiceImpl");
        String message = "Вышло обновление по ссылке "+linkUpdate.url()+" \n"+linkUpdate.description();
        for (Long chatId : linkUpdate.tgChatIds()) {
            bot.sendMessage(chatId, message);
        }
    }

}