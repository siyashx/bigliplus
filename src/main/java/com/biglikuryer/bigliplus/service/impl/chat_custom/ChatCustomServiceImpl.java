package com.biglikuryer.bigliplus.service.impl.chat_custom;

import com.biglikuryer.bigliplus.dao.chat_custom.ChatCustomRepository;
import com.biglikuryer.bigliplus.dto.chat_custom.ChatCustomDto;
import com.biglikuryer.bigliplus.model.chat_custom.ChatCustom;
import com.biglikuryer.bigliplus.service.inter.chat_custom.ChatCustomServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatCustomServiceImpl implements ChatCustomServiceInter {

    private final ChatCustomRepository chatCustomRepository;
    private final ModelMapper modelMapper;

    public ChatCustomServiceImpl(ChatCustomRepository chatCustomRepository, ModelMapper modelMapper) {
        this.chatCustomRepository = chatCustomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChatCustomDto createChatCustom(ChatCustomDto chatCustomDto) {
        ChatCustom chatCustom = modelMapper.map(chatCustomDto, ChatCustom.class);
        chatCustom = chatCustomRepository.save(chatCustom);
        return modelMapper.map(chatCustom, ChatCustomDto.class);
    }

    @Override
    public List<ChatCustomDto> getAllChatCustoms() {
        List<ChatCustom> chatCustoms = chatCustomRepository.findAll();
        return chatCustoms.stream()
                .map(chatCustom -> modelMapper.map(chatCustom, ChatCustomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChatCustomDto getChatCustomById(Long chatCustomId) {
        Optional<ChatCustom> chatCustomOptional = chatCustomRepository.findById(chatCustomId);
        return chatCustomOptional.map(chatCustom -> modelMapper.map(chatCustom, ChatCustomDto.class)).orElse(null);
    }

    @Override
    public ChatCustomDto updateChatCustom(Long chatCustomId, ChatCustomDto chatCustomDto) {
        Optional<ChatCustom> chatCustomOptional = chatCustomRepository.findById(chatCustomId);
        if (chatCustomOptional.isPresent()) {
            ChatCustom chatCustom = chatCustomOptional.get();

            if (chatCustomDto.getOrderId() != null) {
                chatCustom.setOrderId(chatCustomDto.getOrderId());
            }

            if (chatCustomDto.getUserId() != null) {
                chatCustom.setUserId(chatCustomDto.getUserId());
            }

            if (chatCustomDto.getCourierId() != null) {
                chatCustom.setCourierId(chatCustomDto.getCourierId());
            }

            if (chatCustomDto.getMessage() != null) {
                chatCustom.setMessage(chatCustomDto.getMessage());
            }

            if (chatCustomDto.getTime() != null) {
                chatCustom.setTime(chatCustomDto.getTime());
            }

            if (chatCustomDto.getDate() != null) {
                chatCustom.setDate(chatCustomDto.getDate());
            }

            chatCustom = chatCustomRepository.save(chatCustom);
            return modelMapper.map(chatCustom, ChatCustomDto.class);


        }
        return null;
    }

    @Override
    public Boolean removeById(Long chatCustomId) {
        Optional<ChatCustom> chatCustomOptional = chatCustomRepository.findById(chatCustomId);
        if (chatCustomOptional.isPresent()) {
            ChatCustom chatCustom = chatCustomOptional.get();
            chatCustomRepository.delete(chatCustom);
            return true;
        }
        return false;
    }
}
