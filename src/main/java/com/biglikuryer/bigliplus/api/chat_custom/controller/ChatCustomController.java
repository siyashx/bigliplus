package com.biglikuryer.bigliplus.api.chat_custom.controller;

import com.biglikuryer.bigliplus.dto.chat.ChatDto;
import com.biglikuryer.bigliplus.dto.chat_custom.ChatCustomDto;
import com.biglikuryer.bigliplus.service.impl.chat_custom.ChatCustomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ChatCustomController {
    private final ChatCustomServiceImpl chatCustomServiceImpl;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatCustomController(ChatCustomServiceImpl chatCustomServiceImpl, SimpMessagingTemplate messagingTemplate) {
        this.chatCustomServiceImpl = chatCustomServiceImpl;
        this.messagingTemplate = messagingTemplate;
    }


    // Mesaj gönderimi WebSocket ile yapılacak
    @MessageMapping("/sendCustomMessage")
    @SendTo("/topic/private")
    public ChatCustomDto sendMessage(@Payload ChatCustomDto chatCustomMessageDto) {
        // Mesajı kaydet ve ardından döndür
        return chatCustomServiceImpl.createChatCustom(chatCustomMessageDto);
    }

    // List

    @GetMapping("/customChats")
    public ResponseEntity<List<ChatCustomDto>> getAllCustoms() {
        List<ChatCustomDto> chatCustomDtoList = chatCustomServiceImpl.getAllChatCustoms();
        return ResponseEntity.ok(chatCustomDtoList);
    }

    // Create
    @PostMapping("/customChat")
    public ResponseEntity<ChatCustomDto> createCustom(@RequestBody ChatCustomDto chatCustomDto) {
        ChatCustomDto createdCustom = chatCustomServiceImpl.createChatCustom(chatCustomDto);
        return ResponseEntity.ok(createdCustom);
    }

    // Id
    @GetMapping("/customChat/{customChatId}")
    public ResponseEntity<ChatCustomDto> findChatCustomById(@PathVariable Long customId) {
        ChatCustomDto chatCustomDto = chatCustomServiceImpl.getChatCustomById(customId);
        if (chatCustomDto != null) {
            return ResponseEntity.ok(chatCustomDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/customChat/{customChatId}")
    public ResponseEntity<?> updateChatCustom(
            @PathVariable Long customId,
            @RequestBody ChatCustomDto chatCustomDto) {

        try {
            ChatCustomDto updatedChatCustom = chatCustomServiceImpl.updateChatCustom(customId, chatCustomDto);
            if (updatedChatCustom != null) {
                return ResponseEntity.ok(updatedChatCustom);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/customChat/{customChatId}")
    public ResponseEntity<String> deleteChatCustom(@PathVariable Long customId) {
        boolean deleted = chatCustomServiceImpl.removeById(customId);
        if (deleted) {
            return ResponseEntity.ok("ChatCustom deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
