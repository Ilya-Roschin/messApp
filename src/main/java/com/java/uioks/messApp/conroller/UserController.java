package com.java.uioks.messApp.conroller;

import com.java.uioks.messApp.dto.ChatDto;
import com.java.uioks.messApp.dto.MessageDto;
import com.java.uioks.messApp.dto.UserDto;
import com.java.uioks.messApp.entity.Chat;
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
@RequestMapping
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


}










