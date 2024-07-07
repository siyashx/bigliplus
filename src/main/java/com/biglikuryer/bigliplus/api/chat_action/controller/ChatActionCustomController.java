package com.biglikuryer.bigliplus.api.chat_action.controller;

import com.biglikuryer.bigliplus.dto.chat_action.ChatActionDto;
import com.biglikuryer.bigliplus.service.impl.chat_action.ChatActionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/chat")
public class ChatActionCustomController {
    private final ChatActionServiceImpl chatActionServiceImpl;

    public ChatActionCustomController(ChatActionServiceImpl chatActionServiceImpl) {
        this.chatActionServiceImpl = chatActionServiceImpl;
    }

    // List
    @GetMapping
    public ResponseEntity<List<ChatActionDto>> getAllActions() {
        List<ChatActionDto> chatActionDtoList = chatActionServiceImpl.getAllChatActions();
        return ResponseEntity.ok(chatActionDtoList);
    }

    // Create
    @PostMapping
    public ResponseEntity<ChatActionDto> createAction(@RequestBody ChatActionDto chatActionDto) {
        ChatActionDto createdAction = chatActionServiceImpl.createChatAction(chatActionDto);
        return ResponseEntity.ok(createdAction);
    }

    // Id
    @GetMapping("/{actionId}")
    public ResponseEntity<ChatActionDto> findChatActionById(@PathVariable Long actionId) {
        ChatActionDto chatActionDto = chatActionServiceImpl.getChatActionById(actionId);
        if (chatActionDto != null) {
            return ResponseEntity.ok(chatActionDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/{actionId}")
    public ResponseEntity<?> updateChatAction(
            @PathVariable Long actionId,
            @RequestBody ChatActionDto chatActionDto) {

        try {
            ChatActionDto updatedChatAction = chatActionServiceImpl.updateChatAction(actionId, chatActionDto);
            if (updatedChatAction != null) {
                return ResponseEntity.ok(updatedChatAction);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/{actionId}")
    public ResponseEntity<String> deleteChatAction(@PathVariable Long actionId) {
        boolean deleted = chatActionServiceImpl.removeById(actionId);
        if (deleted) {
            return ResponseEntity.ok("ChatAction deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
