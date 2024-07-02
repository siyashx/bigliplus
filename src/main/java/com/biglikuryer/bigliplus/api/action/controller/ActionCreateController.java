package com.biglikuryer.bigliplus.api.action.controller;

import com.biglikuryer.bigliplus.dto.action.ActionDto;
import com.biglikuryer.bigliplus.service.impl.action.ActionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/create/action")
public class ActionCreateController {
    private final ActionServiceImpl actionServiceImpl;

    public ActionCreateController(ActionServiceImpl actionServiceImpl) {
        this.actionServiceImpl = actionServiceImpl;
    }

    // Create
    @PostMapping
    public ResponseEntity<ActionDto> createAction(@RequestBody ActionDto actionDto) {
        ActionDto createdAction = actionServiceImpl.createAction(actionDto);
        return ResponseEntity.ok(createdAction);
    }
}
