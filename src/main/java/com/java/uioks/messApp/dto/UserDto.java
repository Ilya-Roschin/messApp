package com.java.uioks.messApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDto {

    //@NotBlank(message = "chat id is incorrect")
    private Long id;

    @NotBlank(message = "chat id is incorrect")
    private String username;

    @NotBlank(message = "chat id is incorrect")
    private String password;
}
