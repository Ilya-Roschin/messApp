package com.java.uioks.messApp.conroller;

import com.java.uioks.messApp.dto.UserDto;
import com.java.uioks.messApp.entity.Chat;
import com.java.uioks.messApp.entity.Message;
import com.java.uioks.messApp.entity.User;
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
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public void saveUser(@RequestBody final UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/{id}")
    public List<User> findUserById(@PathVariable final long id) {
        return null;
    }

    @GetMapping("/{id}/chat")
    public List<Chat> findAllChats(@PathVariable final long id) {
        return null;
    }

    @PostMapping("/{id}/chat/{chat_id}")
    public void addMessage(@RequestBody final Message message, @PathVariable final long id, @PathVariable final long chat_id) {
        // TODO: 09.04.2022 Chat service addMessage to Repository
    }

    @GetMapping("/{id}/chat/{chat_id}")
    public Chat findChat(@PathVariable final long id, @PathVariable final long chat_id) {
        // TODO: 09.04.2022 Chat service read chat
        return null;
    }

}










