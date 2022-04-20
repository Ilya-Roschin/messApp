package com.java.uioks.messApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ChatDto {

    private Long id;

    private String name;

    private List<MessageDto> messages;

    private List<Long> userIds;


}
