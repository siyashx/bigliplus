package com.biglikuryer.bigliplus.service.inter.chat_action;


import com.biglikuryer.bigliplus.dto.chat_action.ChatActionDto;

import java.util.List;

public interface ChatActionServiceInter {

    ChatActionDto createChatAction(ChatActionDto actionDto);

    List<ChatActionDto> getAllChatActions();

    Boolean removeById(Long actionId);

    ChatActionDto getChatActionById(Long actionId);

    ChatActionDto updateChatAction(Long actionId, ChatActionDto actionDto);
}
