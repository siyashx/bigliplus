package com.biglikuryer.bigliplus.service.inter.chat_custom;


import com.biglikuryer.bigliplus.dto.chat_custom.ChatCustomDto;

import java.util.List;

public interface ChatCustomServiceInter {

    ChatCustomDto createChatCustom(ChatCustomDto chatCustomDto);

    List<ChatCustomDto> getAllChatCustoms();

    Boolean removeById(Long chatCustomId);

    ChatCustomDto getChatCustomById(Long chatCustomId);

    ChatCustomDto updateChatCustom(Long chatCustomId, ChatCustomDto chatCustomDto);
}
