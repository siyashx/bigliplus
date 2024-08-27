package com.biglikuryer.bigliplus.service.inter.chat;

import com.biglikuryer.bigliplus.dto.chat.ChatDto;

import java.util.List;

public interface ChatServiceInter {

    ChatDto createChat(ChatDto chatDto);

    List<ChatDto> getAllChats();

    Boolean removeById(Long chatId);

    ChatDto getChatById(Long chatId);

    ChatDto updateChat(Long chatId, ChatDto chatDto);
}
