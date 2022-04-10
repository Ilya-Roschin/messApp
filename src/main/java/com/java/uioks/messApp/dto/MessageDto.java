package com.java.uioks.messApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Time;

@Getter
@Setter
public class MessageDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    @NotBlank(message = "text is incorrect")
    private String text;

    @NotBlank(message = "time is incorrect")
    private Time time;
}
