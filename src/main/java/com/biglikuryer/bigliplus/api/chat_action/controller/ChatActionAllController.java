package com.biglikuryer.bigliplus.api.chat_action.controller;

import com.biglikuryer.bigliplus.dto.action.ActionDto;
import com.biglikuryer.bigliplus.service.impl.action.ActionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3/chats")
public class ChatActionAllController {
    private final ActionServiceImpl actionServiceImpl;

    public ChatActionAllController(ActionServiceImpl actionServiceImpl) {
        this.actionServiceImpl = actionServiceImpl;
    }

    // List
    @GetMapping
    public ResponseEntity<List<ActionDto>> getAllActions() {
        List<ActionDto> actionDtoList = actionServiceImpl.getAllActions();
        return ResponseEntity.ok(actionDtoList);
    }
}
