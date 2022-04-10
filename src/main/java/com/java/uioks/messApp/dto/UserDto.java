package com.java.uioks.messApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;

    @NotBlank(message = "chat id is incorrect")
    private String username;

    @NotBlank(message = "password is incorrect")
    private String password;

    private List<Long> chatIds;

    private List<Long> messageIds;

}
