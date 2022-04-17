package com.java.uioks.messApp.mapper;

import com.java.uioks.messApp.dto.ChatDto;
import com.java.uioks.messApp.entity.Chat;
import com.java.uioks.messApp.entity.User;
import com.java.uioks.messApp.repository.MessageRepository;
import com.java.uioks.messApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ChatMapper {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageMapper messageMapper;

    public ChatDto toDto(final Chat chat) {
        ChatDto chatDto = new ChatDto();
        chatDto.setId(chat.getId());
        chatDto.setName(chat.getName());
        chatDto.setMessages(chat.getMessages().stream()
                .map(messageMapper::toDto)
                .collect(Collectors.toList()));
        chatDto.setUserIds(chat.getUsers().stream()
                .map(User::getId)
                .collect(Collectors.toList()));
        return chatDto;
    }

    public Chat toEntity(final ChatDto chatDto) {
        return Chat.builder()
                .name(chatDto.getName())
                .messages(chatDto.getMessages().stream()
                        .map(messageMapper::toEntity)
                        .collect(Collectors.toList()))
                .users(findUsersByIds(chatDto.getUserIds()))
                .build();
    }

    private List<User> findUsersByIds(List<Long> userIds) {
        if (Objects.equals(userIds, null)) {
            return new ArrayList<User>();
        }
        return userRepository.findAllById(userIds);
    }
}
