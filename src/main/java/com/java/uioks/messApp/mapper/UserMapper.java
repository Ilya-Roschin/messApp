package com.java.uioks.messApp.mapper;


import com.java.uioks.messApp.dto.UserDto;
import com.java.uioks.messApp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        //userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User toEntity(final UserDto userDto) {
//        return User.builder()
//                .username(userDto.getUsername())
//                .password(userDto.getPassword())
//                .build();
        return null;
    }
}