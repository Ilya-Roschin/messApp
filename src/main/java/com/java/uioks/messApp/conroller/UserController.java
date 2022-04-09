package com.java.uioks.messApp.conroller;

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
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public void saveUser(@RequestBody final User user) {
        userService.save(user);
    }

    @GetMapping(path = "/{id}")
    public List<Chat> findById(@PathVariable final long id) {
        return null;
    }

}










