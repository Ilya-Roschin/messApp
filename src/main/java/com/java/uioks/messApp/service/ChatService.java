package com.java.uioks.messApp.service;

import com.java.uioks.messApp.dto.ChatDto;
import com.java.uioks.messApp.entity.Chat;
import com.java.uioks.messApp.exception.EntityNotFoundException;
import com.java.uioks.messApp.mapper.ChatMapper;
import com.java.uioks.messApp.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public void createChat(final Long userId, final String chatName) {
        Chat chat = new Chat();
        chat.setName(chatName);
        chat.addUser(userService.findUserById(userId));
        System.out.println(chat);
        //chatRepository.save(chat);
        // TODO: 21.04.2022 refactor
    }

    public List<ChatDto> findAllChatsByUserId(final Long userId) {
        return userService.findUserById(userId).getChats().stream()
                .map(chatMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ChatDto> findAllChats() {
       return chatRepository.findAll().stream()
                .map(chatMapper::toDto)
                .collect(Collectors.toList());
    }
}
