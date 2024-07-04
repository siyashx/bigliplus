package com.biglikuryer.bigliplus.service.inter.chat_action;


import com.biglikuryer.bigliplus.dto.chat_action.ChatActionDto;

import java.util.List;

public interface ChatActionServiceInter {

    ChatActionDto createChatAction(ChatActionDto chatActionDto);

    List<ChatActionDto> getAllChatActions();

    Boolean removeById(Long chatActionId);

    ChatActionDto getChatActionById(Long chatActionId);

    ChatActionDto updateChatAction(Long chatActionId, ChatActionDto chatActionDto);
}
