package com.java.uioks.messApp.conroller;

import com.java.uioks.messApp.dto.UserDto;
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

    @GetMapping("users/findAll")
    public List<UserDto> findAll() {
        return userService.findAll();
    }


    @PostMapping("/users/create")
    public void createUser(@RequestBody final UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/users/find/{user_id}")
    public UserDto findUserById(@PathVariable final Long user_id) {
        return userService.findUserDtoById(user_id);
    }

    @GetMapping("users/login")
    public boolean isUserAuthorised(@RequestBody final UserDto userDto) {
        return userService.isUserAuthorised(userDto);
    }
}










