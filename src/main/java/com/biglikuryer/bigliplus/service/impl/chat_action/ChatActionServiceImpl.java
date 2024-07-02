package com.biglikuryer.bigliplus.service.impl.chat_action;

import com.biglikuryer.bigliplus.dao.chat_action.ChatActionRepository;
import com.biglikuryer.bigliplus.dto.chat_action.ChatActionDto;
import com.biglikuryer.bigliplus.model.chat_action.ChatAction;
import com.biglikuryer.bigliplus.service.inter.chat_action.ChatActionServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatActionServiceImpl implements ChatActionServiceInter {

    private final ChatActionRepository chatActionRepository;
    private final ModelMapper modelMapper;

    public ChatActionServiceImpl(ChatActionRepository chatActionRepository, ModelMapper modelMapper) {
        this.chatActionRepository = chatActionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChatActionDto createChatAction(ChatActionDto chatActionDto) {
        ChatAction chatAction = modelMapper.map(chatActionDto, ChatAction.class);
        chatAction = chatActionRepository.save(chatAction);
        return modelMapper.map(chatAction, ChatActionDto.class);
    }

    @Override
    public List<ChatActionDto> getAllChatActions() {
        List<ChatAction> chatActions = chatActionRepository.findAll();
        return chatActions.stream()
                .map(chatAction -> modelMapper.map(chatAction, ChatActionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChatActionDto getChatActionById(Long chatActionId) {
        Optional<ChatAction> chatActionOptional = chatActionRepository.findById(chatActionId);
        return chatActionOptional.map(chatAction -> modelMapper.map(chatAction, ChatActionDto.class)).orElse(null);
    }

    @Override
    public ChatActionDto updateChatAction(Long chatActionId, ChatActionDto chatActionDto) {
        Optional<ChatAction> chatActionOptional = chatActionRepository.findById(chatActionId);
        if (chatActionOptional.isPresent()) {
            ChatAction chatAction = chatActionOptional.get();

            if (chatActionDto.getActionId() != null) {
                chatAction.setActionId(chatActionDto.getActionId());
            }

            if (chatActionDto.getUserId() != null) {
                chatAction.setUserId(chatActionDto.getUserId());
            }

            if (chatActionDto.getIsCustomer() != null) {
                chatAction.setIsCustomer(chatActionDto.getIsCustomer());
            }

            if (chatActionDto.getMessage() != null) {
                chatAction.setMessage(chatActionDto.getMessage());
            }

            if (chatActionDto.getTime() != null) {
                chatAction.setTime(chatActionDto.getTime());
            }

            if (chatActionDto.getDate() != null) {
                chatAction.setDate(chatActionDto.getDate());
            }

            chatAction = chatActionRepository.save(chatAction);
            return modelMapper.map(chatAction, ChatActionDto.class);


        }
        return null;
    }

    @Override
    public Boolean removeById(Long chatActionId) {
        Optional<ChatAction> chatActionOptional = chatActionRepository.findById(chatActionId);
        if (chatActionOptional.isPresent()) {
            ChatAction chatAction = chatActionOptional.get();
            chatActionRepository.delete(chatAction);
            return true;
        }
        return false;
    }
}
