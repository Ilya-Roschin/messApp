package com.java.uioks.messApp.service;

import com.java.uioks.messApp.dto.MessageDto;
import com.java.uioks.messApp.mapper.MessageMapper;
import com.java.uioks.messApp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageMapper messageMapper;

    public List<MessageDto> findAllMessages() {
        return messageRepository.findAll().stream()
                .map(messageMapper::toDto)
                .collect(Collectors.toList());
    }

    public void addMessage(MessageDto messageDto, Long userId, Long chatId) {
        messageDto.setUserId(userId);
        messageDto.setChatId(chatId);
        System.out.println(messageDto);
        messageRepository.save(messageMapper.toEntity(messageDto));
    }
}
