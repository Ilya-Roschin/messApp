package com.java.uioks.messApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Time;

@Getter
@Setter
public class MessageDto {

    private Long id;

    @NotBlank(message = "text is incorrect")
    private String text;

    @NotBlank(message = "time is incorrect")
    private Time time;

    @NotBlank(message = "userId is incorrect")
    private long userId;

    @NotBlank(message = "userId is incorrect")
    private long chatId;


}
