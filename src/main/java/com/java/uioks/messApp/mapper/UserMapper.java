package com.java.uioks.messApp.mapper;


import com.java.uioks.messApp.dto.UserDto;
import com.java.uioks.messApp.entity.Chat;
import com.java.uioks.messApp.entity.Message;
import com.java.uioks.messApp.entity.User;
import com.java.uioks.messApp.repository.ChatRepository;
import com.java.uioks.messApp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    public UserDto toDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setChatIds(userDto.getChatIds());
        return userDto;
    }

    public User toEntity(final UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .chats(findChatsByIds(userDto.getChatIds()))
                .messages(findMessagesByIds(userDto.getMessageIds()))
                .build();
    }

    private List<Chat> findChatsByIds(List<Long> chatIds) {
          return chatRepository.findAllById(chatIds);
    }

    private List<Message> findMessagesByIds(List<Long> messageIds) {
        return messageRepository.findAllById(messageIds);
    }

}