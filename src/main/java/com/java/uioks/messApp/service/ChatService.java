package com.java.uioks.messApp.service;

import com.java.uioks.messApp.dto.ChatDto;
import com.java.uioks.messApp.dto.TextDto;
import com.java.uioks.messApp.entity.Chat;
import com.java.uioks.messApp.entity.User;
import com.java.uioks.messApp.exception.EntityNotFoundException;
import com.java.uioks.messApp.mapper.ChatMapper;
import com.java.uioks.messApp.repository.ChatRepository;
import com.java.uioks.messApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ChatMapper chatMapper;


    public ChatDto getChatById(final Long chatId) {
        return chatMapper.toDto(chatRepository.findById(chatId).orElseThrow(() ->
                new EntityNotFoundException("chat not founded by id: " + chatId)));
    }

    public void createChat(final Long userId, final TextDto chatName) {
        Chat chat = new Chat();
        chat.setName(chatName.getText());
        User user = userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("user not founded by id: " + userId));
        user.addChat(chat);
        chat.addUser(user);
        chatRepository.save(chat);
    }

    public void addUserToChat(Long userId, Long chatId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("user not founded by id: " + userId));
        Chat chat = chatRepository.findById(chatId).orElseThrow(() ->
                new EntityNotFoundException("chat not founded by id: " + chatId));
        user.addChat(chat);
        chat.addUser(user);
        chatRepository.save(chat);
    }

    public List<ChatDto> findAllChatsByUserId(final Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                        new EntityNotFoundException("user not founded by id: " + userId)).getChats().stream()
                .map(chatMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ChatDto> findAllChats() {
        return chatRepository.findAll().stream()
                .map(chatMapper::toDto)
                .collect(Collectors.toList());
    }
}