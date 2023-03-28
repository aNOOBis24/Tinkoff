package ru.tinkoff.edu.java.scrapper.service;

import org.springframework.stereotype.Service;

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