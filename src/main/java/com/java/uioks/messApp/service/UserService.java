package com.java.uioks.messApp.service;

import com.java.uioks.messApp.dto.UserDto;
import com.java.uioks.messApp.entity.User;
import com.java.uioks.messApp.exception.EntityNotFoundException;
import com.java.uioks.messApp.mapper.UserMapper;
import com.java.uioks.messApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> findAll() {
        userRepository.findAll().forEach(System.out::println);
        return userRepository.findAll().stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());
    }

    public User findByUsername(final String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new EntityNotFoundException("user not founded: " + username));
    }

    public void save(final UserDto userDto) {
        System.out.println(userMapper.toEntity(userDto));
        userRepository.save(userMapper.toEntity(userDto));
    }

    public void findAllChatsByUserId(final Long id) {
        userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("user not founded by id: " + id));

    }

    public User findUserById(final Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("user not founded by id: " + id));
    }

    public UserDto findUserDtoById(final Long id) {
        return userMapper.toDto(findUserById(id));
    }

    public long isUserAuthorised(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername()).orElseThrow(() ->
                new EntityNotFoundException("user not founded by name: " + userDto.getUsername()));

        if (userDto.getPassword().equals(user.getPassword())) {
            return userDto.getId();
        } else {
            return 0;
        }
    }
}

