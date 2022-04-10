package com.java.uioks.messApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class ChatDto {

    @NotBlank(message = "chat id is incorrect")
    private Long id;

    private List<MessageDto> messages;
}
