package com.java.uioks.messApp.mapper;

import com.java.uioks.messApp.dto.MessageDto;
import com.java.uioks.messApp.entity.Chat;
import com.java.uioks.messApp.entity.Message;
import com.java.uioks.messApp.entity.User;
import com.java.uioks.messApp.exception.EntityNotFoundException;
import com.java.uioks.messApp.repository.ChatRepository;
import com.java.uioks.messApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MessageMapper {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    public MessageDto toDto(final Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setText(message.getText());
        messageDto.setChatId(message.getChat().getId());
        messageDto.setTime(message.getTime());
        return messageDto;
    }

    public Message toEntity(final MessageDto messageDto) {
        return Message.builder()
                .chat(findChatById(messageDto.getChatId()))
                .time(messageDto.getTime())
                .text(messageDto.getText())
                .user(findUserById(messageDto.getUserId()))
                .build();
    }

    public Chat findChatById(final Long id) {
        if (Objects.equals(id, null)) {
            return null;
        }
        return chatRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("chat not founded by id: " + id));
    }

    public User findUserById(final Long id) {
        if (Objects.equals(id, null)) {
            return null;
        }
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("user not founded by id: " + id));
    }

}
