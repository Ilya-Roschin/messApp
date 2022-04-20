package com.java.uioks.messApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.sql.Time;

@Getter
@Setter
@ToString
public class MessageDto {

    private Long id;

    @NotBlank(message = "text is incorrect")
    private String text;

    private Time time;

    private long userId;

    private long chatId;


}
