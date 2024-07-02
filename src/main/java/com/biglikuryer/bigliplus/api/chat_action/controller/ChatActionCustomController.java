package com.biglikuryer.bigliplus.api.chat_action.controller;

import com.biglikuryer.bigliplus.dto.chat_action.ChatActionDto;
import com.biglikuryer.bigliplus.service.impl.chat_action.ChatActionServiceImpl;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/chat")
public class ChatActionCustomController {
    private final ChatActionServiceImpl actionServiceImpl;

    public ChatActionCustomController(ChatActionServiceImpl actionServiceImpl) {
        this.actionServiceImpl = actionServiceImpl;
    }

    // Id
    @GetMapping("/{actionId}")
    public ResponseEntity<ChatActionDto> findChatActionById(@PathVariable Long actionId) {
        ChatActionDto actionDto = actionServiceImpl.getChatActionById(actionId);
        if (actionDto != null) {
            return ResponseEntity.ok(actionDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/{actionId}")
    public ResponseEntity<?> updateChatAction(
            @PathVariable Long actionId,
            @RequestBody ChatActionDto actionDto) {

        try {
            ChatActionDto updatedChatAction = actionServiceImpl.updateChatAction(actionId, actionDto);
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
        boolean deleted = actionServiceImpl.removeById(actionId);
        if (deleted) {
            return ResponseEntity.ok("ChatAction deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
