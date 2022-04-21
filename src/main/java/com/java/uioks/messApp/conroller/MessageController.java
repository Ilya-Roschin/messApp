package com.java.uioks.messApp.conroller;

import com.java.uioks.messApp.dto.MessageDto;
import com.java.uioks.messApp.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages/get/{message_id}")
    public MessageDto findMessageById(@PathVariable final long message_id) {
        return messageService.findById(message_id);
    }

    @PostMapping("/messages/{user_id}/{chat_id}/addMessage")
    public void addMessage(@RequestBody final MessageDto messageDto, @PathVariable final long user_id, @PathVariable final long chat_id) {
        messageService.addMessage(messageDto, user_id, chat_id);
    }

    @DeleteMapping("/messages/delete/{message_id}")
    public void deleteById(@PathVariable final long message_id) {
        messageService.deleteById(message_id);
    }

}
