package com.biglikuryer.bigliplus.service.impl.chat;

import com.biglikuryer.bigliplus.dao.chat.ChatRepository;
import com.biglikuryer.bigliplus.dto.chat.ChatDto;
import com.biglikuryer.bigliplus.model.chat.Chat;
import com.biglikuryer.bigliplus.service.inter.chat.ChatServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatServiceImpl implements ChatServiceInter {

    private final ChatRepository chatRepository;
    private final ModelMapper modelMapper;

    public ChatServiceImpl(ChatRepository chatRepository, ModelMapper modelMapper) {
        this.chatRepository = chatRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChatDto createChat(ChatDto chatDto) {
        Chat chat = modelMapper.map(chatDto, Chat.class);
        chat = chatRepository.save(chat);
        return modelMapper.map(chat, ChatDto.class);
    }

    @Override
    public List<ChatDto> getAllChats() {
        List<Chat> chats = chatRepository.findAll();
        return chats.stream()
                .map(chat -> modelMapper.map(chat, ChatDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChatDto getChatById(Long chatId) {
        Optional<Chat> chatOptional = chatRepository.findById(chatId);
        return chatOptional.map(chat -> modelMapper.map(chat, ChatDto.class)).orElse(null);
    }

    @Override
    public ChatDto updateChat(Long chatId, ChatDto chatDto) {
        Optional<Chat> chatOptional = chatRepository.findById(chatId);
        if (chatOptional.isPresent()) {
            Chat chat = chatOptional.get();

            // Update fields only if they are not null
            if (chatDto.getUserId() != null) {
                chat.setUserId(chatDto.getUserId());
            }

            if (chatDto.getIsSeenId() != null) {
                chat.setIsSeenId(chatDto.getIsSeenId());
            }

            if (chatDto.getIsForwarded() != null) {
                chat.setIsForwarded(chatDto.getIsForwarded());
            }

            if (chatDto.getForwardedId() != null) {
                chat.setForwardedId(chatDto.getForwardedId());
            }

            if (chatDto.getIsCustomer() != null) {
                chat.setIsCustomer(chatDto.getIsCustomer());
            }

            if (chatDto.getIsAdmin() != null) {
                chat.setIsAdmin(chatDto.getIsAdmin());
            }

            if (chatDto.getMessage() != null) {
                chat.setMessage(chatDto.getMessage());
            }

            if (chatDto.getTime() != null) {
                chat.setTime(chatDto.getTime());
            }

            if (chatDto.getDate() != null) {
                chat.setDate(chatDto.getDate());
            }

            chat = chatRepository.save(chat);
            return modelMapper.map(chat, ChatDto.class);
        }
        return null;
    }

    @Override
    public Boolean removeById(Long chatId) {
        Optional<Chat> chatOptional = chatRepository.findById(chatId);
        if (chatOptional.isPresent()) {
            chatRepository.delete(chatOptional.get());
            return true;
        }
        return false;
    }
}