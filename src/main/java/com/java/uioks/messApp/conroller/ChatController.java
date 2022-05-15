package com.java.uioks.messApp.conroller;


import com.java.uioks.messApp.dto.ChatDto;
import com.java.uioks.messApp.dto.TextDto;
import com.java.uioks.messApp.entity.Chat;
import com.java.uioks.messApp.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chats/findAll/user/{user_id}")
    public List<ChatDto> findAllChatsByUserId(@PathVariable final Long user_id) {
        return chatService.findAllChatsByUserId(user_id);
    }

    @GetMapping("/chats/findAll")
    public List<ChatDto> findAllChat() {
        return chatService.findAllChats();
    }

    @GetMapping("/chats/find/{chat_id}")
    public ChatDto getChatById(@PathVariable final long chat_id) {
        return chatService.getChatById(chat_id);
    }

    @PostMapping("/chats/create/{user_id}")
    public void createNewChat(@PathVariable final long user_id, @RequestBody TextDto chatName) {
        chatService.createChat(user_id, chatName);
    }

    @PostMapping("/chats/{chat_id}/addToChat/{user_id}")
    public void addUserToChat(@PathVariable final long user_id, @PathVariable final long chat_id) {
        chatService.addUserToChat(user_id, chat_id);
    }
}
