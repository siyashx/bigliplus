package com.biglikuryer.bigliplus.api.chat.controller;

import com.biglikuryer.bigliplus.dto.chat.ChatDto;
import com.biglikuryer.bigliplus.model.chat.Chat;
import com.biglikuryer.bigliplus.service.impl.chat.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v3")
public class ChatController {

    @Autowired
    private ChatServiceImpl chatServiceImpl;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // WebSocket Messaging

    @MessageMapping("/sendMessage")
    public void sendMessage(@Payload ChatDto chatMessageDto) {
        // ChatDto'yu Chat entity'sine dönüştür
        Chat chatMessage = convertToEntity(chatMessageDto);
        // Chat mesajını veritabanına kaydet
        chatServiceImpl.createChat(chatMessageDto); // Bu metod ChatDto alıyor ve veritabanına kaydediyor
        // Chat mesajını tüm abone olan istemcilere gönder
        messagingTemplate.convertAndSend("/topic/public", chatMessageDto);
    }

    @MessageMapping("/getMessages")
    public void getMessages() {
        // Tüm chat mesajlarını veritabanından al
        List<ChatDto> messages = chatServiceImpl.getAllChats();
        // Tüm mesajları tüm abone olan istemcilere gönder
        messagingTemplate.convertAndSend("/topic/public", messages);
    }

    // CRUD Operations for Chat

    @PostMapping("/chat")
    public ResponseEntity<ChatDto> createChat(@RequestBody ChatDto chatDto) {
        ChatDto createdChat = chatServiceImpl.createChat(chatDto);
        return ResponseEntity.ok(createdChat);
    }

    @GetMapping("/chat/{chatId}")
    public ResponseEntity<ChatDto> findChatById(@PathVariable Long chatId) {
        ChatDto chatDto = chatServiceImpl.getChatById(chatId);
        if (chatDto != null) {
            return ResponseEntity.ok(chatDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/chat/{chatId}")
    public ResponseEntity<?> updateChat(
            @PathVariable Long chatId,
            @RequestBody ChatDto chatDto) {

        try {
            ChatDto updatedChat = chatServiceImpl.updateChat(chatId, chatDto);
            if (updatedChat != null) {
                return ResponseEntity.ok(updatedChat);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/chat/{chatId}")
    public ResponseEntity<String> deleteChat(@PathVariable Long chatId) {
        boolean deleted = chatServiceImpl.removeById(chatId);
        if (deleted) {
            return ResponseEntity.ok("Chat deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    private Chat convertToEntity(ChatDto chatDto) {
        return Chat.builder()
                .id(chatDto.getId())
                .userId(chatDto.getUserId())
                .isSeenId(chatDto.getIsSeenId())
                .isForwarded(chatDto.getIsForwarded())
                .forwardedId(chatDto.getForwardedId())
                .isCustomer(chatDto.getIsCustomer())
                .isAdmin(chatDto.getIsAdmin())
                .message(chatDto.getMessage())
                .time(chatDto.getTime())
                .date(chatDto.getDate())
                .build();
    }
}