package com.biglikuryer.bigliplus.event.chat;

import com.biglikuryer.bigliplus.dto.chat.ChatDto;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class ChatMessageReceivedEvent extends ApplicationEvent {

    private final List<ChatDto> messages;

    public ChatMessageReceivedEvent(Object source, List<ChatDto> messages) {
        super(source);
        this.messages = messages;
    }

    public List<ChatDto> getMessages() {
        return messages;
    }
}

