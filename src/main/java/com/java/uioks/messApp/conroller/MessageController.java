package com.java.uioks.messApp.conroller;

import com.java.uioks.messApp.dto.MessageDto;
import com.java.uioks.messApp.service.MessageService;
import com.java.uioks.messApp.service.UserService;
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
public class MessageController {

    @Autowired
    private MessageService messageService;


    @GetMapping("/messages")
    public List<MessageDto> findAllMessages() {
        return messageService.findAllMessages();
    }

    @PostMapping("/{user_id}/chat/{chat_id}")
    public void addMessage(@RequestBody final MessageDto messageDto, @PathVariable final long user_id, @PathVariable final long chat_id) {
        messageService.addMessage(messageDto, user_id, chat_id);
    }

}
