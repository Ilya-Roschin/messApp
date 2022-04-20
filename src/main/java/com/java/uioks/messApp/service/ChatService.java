package com.java.uioks.messApp.service;

import com.java.uioks.messApp.dto.ChatDto;
import com.java.uioks.messApp.entity.Chat;
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
    private UserService userService;

    @Autowired
    private ChatMapper chatMapper;


    public ChatDto getChatById(final Long chatId) {
        return chatMapper.toDto(chatRepository.findById(chatId).orElseThrow(() ->
                new EntityNotFoundException("chat not founded by id: " + chatId)));
    }

    public void createChat(Long userId, String chatName) {
        Chat chat = new Chat();
        chat.setName(chatName);
        chat.addUser(userService.findUserById(userId));
        chatRepository.save(chat);
    }

}
