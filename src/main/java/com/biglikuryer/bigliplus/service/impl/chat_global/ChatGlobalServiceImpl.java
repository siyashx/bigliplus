package com.biglikuryer.bigliplus.service.impl.chat_global;

import com.biglikuryer.bigliplus.dao.chat_global.ChatGlobalRepository;
import com.biglikuryer.bigliplus.dto.chat_global.ChatGlobalDto;
import com.biglikuryer.bigliplus.model.chat_global.ChatGlobal;
import com.biglikuryer.bigliplus.service.inter.chat_global.ChatGlobalServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatGlobalServiceImpl implements ChatGlobalServiceInter {

    private final ChatGlobalRepository chatGlobalRepository;
    private final ModelMapper modelMapper;

    public ChatGlobalServiceImpl(ChatGlobalRepository chatGlobalRepository, ModelMapper modelMapper) {
        this.chatGlobalRepository = chatGlobalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChatGlobalDto createChatGlobal(ChatGlobalDto chatGlobalDto) {
        ChatGlobal chatGlobal = modelMapper.map(chatGlobalDto, ChatGlobal.class);
        chatGlobal = chatGlobalRepository.save(chatGlobal);
        return modelMapper.map(chatGlobal, ChatGlobalDto.class);
    }

    @Override
    public List<ChatGlobalDto> getAllChatGlobals() {
        List<ChatGlobal> chatGlobals = chatGlobalRepository.findAll();
        return chatGlobals.stream()
                .map(chatGlobal -> modelMapper.map(chatGlobal, ChatGlobalDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChatGlobalDto getChatGlobalById(Long chatGlobalId) {
        Optional<ChatGlobal> chatGlobalOptional = chatGlobalRepository.findById(chatGlobalId);
        return chatGlobalOptional.map(chatGlobal -> modelMapper.map(chatGlobal, ChatGlobalDto.class)).orElse(null);
    }

    @Override
    public ChatGlobalDto updateChatGlobal(Long chatGlobalId, ChatGlobalDto chatGlobalDto) {
        Optional<ChatGlobal> chatGlobalOptional = chatGlobalRepository.findById(chatGlobalId);
        if (chatGlobalOptional.isPresent()) {
            ChatGlobal chatGlobal = chatGlobalOptional.get();

            if (chatGlobalDto.getUserId() != null) {
                chatGlobal.setUserId(chatGlobalDto.getUserId());
            }

            if (chatGlobalDto.getIsSeenId() != null) {
                chatGlobal.setIsSeenId(chatGlobalDto.getIsSeenId());
            }

            if (chatGlobalDto.getIsForwarded() != null) {
                chatGlobal.setIsForwarded(chatGlobalDto.getIsForwarded());
            }

            if (chatGlobalDto.getForwardedId() != null) {
                chatGlobal.setForwardedId(chatGlobalDto.getForwardedId());
            }

            if (chatGlobalDto.getIsCustomer() != null) {
                chatGlobal.setIsCustomer(chatGlobalDto.getIsCustomer());
            }

            if (chatGlobalDto.getIsAdmin() != null) {
                chatGlobal.setIsAdmin(chatGlobalDto.getIsAdmin());
            }

            if (chatGlobalDto.getMessage() != null) {
                chatGlobal.setMessage(chatGlobalDto.getMessage());
            }

            if (chatGlobalDto.getTime() != null) {
                chatGlobal.setTime(chatGlobalDto.getTime());
            }

            if (chatGlobalDto.getDate() != null) {
                chatGlobal.setDate(chatGlobalDto.getDate());
            }

            chatGlobal = chatGlobalRepository.save(chatGlobal);
            return modelMapper.map(chatGlobal, ChatGlobalDto.class);


        }
        return null;
    }

    @Override
    public Boolean removeById(Long chatGlobalId) {
        Optional<ChatGlobal> chatGlobalOptional = chatGlobalRepository.findById(chatGlobalId);
        if (chatGlobalOptional.isPresent()) {
            ChatGlobal chatGlobal = chatGlobalOptional.get();
            chatGlobalRepository.delete(chatGlobal);
            return true;
        }
        return false;
    }
}
