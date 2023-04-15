package ru.tinkoff.edu.java.bot.service;

import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.bot.repository.ChatRepository;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public void registerChat(Long id) {
        chatRepository.save(id);
    }


    public void deleteChat(Long id) {
        chatRepository.deleteByChatId(id);
    }
}