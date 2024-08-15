package com.biglikuryer.bigliplus.service.inter.chat_global;


import com.biglikuryer.bigliplus.dto.chat_global.ChatGlobalDto;

import java.util.List;

public interface ChatGlobalServiceInter {

    ChatGlobalDto createChatGlobal(ChatGlobalDto chatGlobalDto);

    List<ChatGlobalDto> getAllChatGlobals();

    Boolean removeById(Long chatGlobalId);

    ChatGlobalDto getChatGlobalById(Long chatGlobalId);

    ChatGlobalDto updateChatGlobal(Long chatGlobalId, ChatGlobalDto chatGlobalDto);
}
