package com.biglikuryer.bigliplus.api.chat_action.controller;

import com.biglikuryer.bigliplus.dto.chat_action.ChatActionDto;
import com.biglikuryer.bigliplus.service.impl.chat_action.ChatActionServiceImpl;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/chat")
public class ChatActionCustomController {
    private final ChatActionServiceImpl chatActionServiceImpl;

    public ChatActionCustomController(ChatActionServiceImpl actionServiceImpl) {
        this.chatActionServiceImpl = actionServiceImpl;
    }

    // List
    @GetMapping
    public ResponseEntity<List<ChatActionDto>> getAllActions() {
        List<ChatActionDto> ChatActionDtoList = chatActionServiceImpl.getAllChatActions();
        return ResponseEntity.ok(ChatActionDtoList);
    }

    // Create
    @PostMapping
    public ResponseEntity<ChatActionDto> createAction(@RequestBody ChatActionDto ChatActionDto) {
        ChatActionDto createdAction = chatActionServiceImpl.createChatAction(ChatActionDto);
        return ResponseEntity.ok(createdAction);
    }

    // Id
    @GetMapping("/{actionId}")
    public ResponseEntity<ChatActionDto> findChatActionById(@PathVariable Long actionId) {
        ChatActionDto ChatActionDto = chatActionServiceImpl.getChatActionById(actionId);
        if (ChatActionDto != null) {
            return ResponseEntity.ok(ChatActionDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/{actionId}")
    public ResponseEntity<?> updateChatAction(
            @PathVariable Long actionId,
            @RequestBody ChatActionDto ChatActionDto) {

        try {
            ChatActionDto updatedChatAction = chatActionServiceImpl.updateChatAction(actionId, ChatActionDto);
            if (updatedChatAction != null) {
                return ResponseEntity.ok(updatedChatAction);
            }
            return ResponseEntity.notFound().build();
        } catch (OptimisticLockException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("ChatAction has been modified by another user. Please try again.");
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
