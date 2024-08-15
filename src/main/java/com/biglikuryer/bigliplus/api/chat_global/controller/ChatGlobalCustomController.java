package com.biglikuryer.bigliplus.api.chat_global.controller;

import com.biglikuryer.bigliplus.dto.chat_global.ChatGlobalDto;
import com.biglikuryer.bigliplus.service.impl.chat_global.ChatGlobalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/chat/global")
public class ChatGlobalCustomController {
    private final ChatGlobalServiceImpl chatGlobalServiceImpl;

    public ChatGlobalCustomController(ChatGlobalServiceImpl chatGlobalServiceImpl) {
        this.chatGlobalServiceImpl = chatGlobalServiceImpl;
    }

    // List
    @GetMapping
    public ResponseEntity<List<ChatGlobalDto>> getAllGlobals() {
        List<ChatGlobalDto> chatGlobalDtoList = chatGlobalServiceImpl.getAllChatGlobals();
        return ResponseEntity.ok(chatGlobalDtoList);
    }

    // Create
    @PostMapping
    public ResponseEntity<ChatGlobalDto> createGlobal(@RequestBody ChatGlobalDto chatGlobalDto) {
        ChatGlobalDto createdGlobal = chatGlobalServiceImpl.createChatGlobal(chatGlobalDto);
        return ResponseEntity.ok(createdGlobal);
    }

    // Id
    @GetMapping("/{globalId}")
    public ResponseEntity<ChatGlobalDto> findChatGlobalById(@PathVariable Long globalId) {
        ChatGlobalDto chatGlobalDto = chatGlobalServiceImpl.getChatGlobalById(globalId);
        if (chatGlobalDto != null) {
            return ResponseEntity.ok(chatGlobalDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/{globalId}")
    public ResponseEntity<?> updateChatGlobal(
            @PathVariable Long globalId,
            @RequestBody ChatGlobalDto chatGlobalDto) {

        try {
            ChatGlobalDto updatedChatGlobal = chatGlobalServiceImpl.updateChatGlobal(globalId, chatGlobalDto);
            if (updatedChatGlobal != null) {
                return ResponseEntity.ok(updatedChatGlobal);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/{globalId}")
    public ResponseEntity<String> deleteChatGlobal(@PathVariable Long globalId) {
        boolean deleted = chatGlobalServiceImpl.removeById(globalId);
        if (deleted) {
            return ResponseEntity.ok("ChatGlobal deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
