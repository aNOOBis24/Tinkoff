package ru.tinkoff.edu.java.bot.service;

import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.bot.dto.AddLinkRequest;
import ru.tinkoff.edu.java.bot.dto.RemoveLinkRequest;
import ru.tinkoff.edu.java.bot.model.Link;
import ru.tinkoff.edu.java.bot.repository.ChatRepository;

import java.util.List;

@Service
public class LinkService {


    private final ChatRepository chatRepository;

    public LinkService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<Link> getLinks(long chatId) {
        return chatRepository.getLinksByChatId(chatId).stream().toList();
    }

    public Link addLink(Long chatId, AddLinkRequest request) {
        return chatRepository.addLinkToChat(chatId, request.link());
    }

    public Link deleteLink(Long chatId, RemoveLinkRequest request) {
        return chatRepository.deleteLinkFromChat(chatId, request.link());
    }
}