package com.biglikuryer.bigliplus.api.action.controller;

import com.biglikuryer.bigliplus.dto.action.ActionDto;
import com.biglikuryer.bigliplus.service.impl.action.ActionServiceImpl;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/action")
public class ActionCustomController {
    private final ActionServiceImpl actionServiceImpl;

    public ActionCustomController(ActionServiceImpl actionServiceImpl) {
        this.actionServiceImpl = actionServiceImpl;
    }

    // List
    @GetMapping
    public ResponseEntity<List<ActionDto>> getAllActions() {
        List<ActionDto> actionDtoList = actionServiceImpl.getAllActions();
        return ResponseEntity.ok(actionDtoList);
    }

    // Create
    @PostMapping
    public ResponseEntity<ActionDto> createAction(@RequestBody ActionDto actionDto) {
        ActionDto createdAction = actionServiceImpl.createAction(actionDto);
        return ResponseEntity.ok(createdAction);
    }

    // Id
    @GetMapping("/{actionId}")
    public ResponseEntity<ActionDto> findActionById(@PathVariable Long actionId) {
        ActionDto actionDto = actionServiceImpl.getActionById(actionId);
        if (actionDto != null) {
            return ResponseEntity.ok(actionDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/{actionId}")
    public ResponseEntity<?> updateAction(
            @PathVariable Long actionId,
            @RequestBody ActionDto actionDto) {

        try {
            ActionDto updatedAction = actionServiceImpl.updateAction(actionId, actionDto);
            if (updatedAction != null) {
                return ResponseEntity.ok(updatedAction);
            }
            return ResponseEntity.notFound().build();
        } catch (OptimisticLockException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Action has been modified by another user. Please try again.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/{actionId}")
    public ResponseEntity<String> deleteAction(@PathVariable Long actionId) {
        boolean deleted = actionServiceImpl.removeById(actionId);
        if (deleted) {
            return ResponseEntity.ok("Action deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
