package com.java.uioks.messApp.service;

import com.java.uioks.messApp.dto.UserDto;
import com.java.uioks.messApp.entity.User;
import com.java.uioks.messApp.exception.EntityNotFoundException;
import com.java.uioks.messApp.mapper.UserMapper;
import com.java.uioks.messApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUsername(final String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new EntityNotFoundException("user not founded: "  + username));
    }

    public void save(final UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }


}
