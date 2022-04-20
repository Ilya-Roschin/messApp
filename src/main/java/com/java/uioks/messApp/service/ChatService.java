package com.java.uioks.messApp.service;

import com.java.uioks.messApp.dto.ChatDto;
import com.java.uioks.messApp.exception.EntityNotFoundException;
import com.java.uioks.messApp.mapper.ChatMapper;
import com.java.uioks.messApp.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ChatMapper chatMapper;


    public ChatDto getChatById(final Long chatId) {
        return chatMapper.toDto(chatRepository.findById(chatId).orElseThrow(() ->
                new EntityNotFoundException("chat not founded by id: " + chatId)));
    }
}
