package com.java.uioks.messApp.conroller;


import com.java.uioks.messApp.dto.ChatDto;
import com.java.uioks.messApp.entity.Chat;
import com.java.uioks.messApp.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatController chatController;

    @GetMapping("/{id}/chats")
    public List<Chat> findAllChats(@PathVariable final long id) {
        return null;
    }

    @GetMapping("/{user_id}/chat/{chat_id}")
    public ChatDto getChatById(@PathVariable final long chat_id) {
        return chatService.getChatById(chat_id);
    }
}
