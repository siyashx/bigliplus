package com.biglikuryer.bigliplus.api.notification.controller;

import com.biglikuryer.bigliplus.dto.notification.AdminNotificationDto;
import com.biglikuryer.bigliplus.service.impl.notification.AdminNotificationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/adminNotification")
public class AdminNotificationController {

    private final AdminNotificationImpl service;

    public AdminNotificationController(AdminNotificationImpl service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<AdminNotificationDto>> getAllAdminNotification() {
        List<AdminNotificationDto> all = service.getAllAdminNotification();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<AdminNotificationDto> getAdminNotificationById(@PathVariable("detId") Long id) {
        AdminNotificationDto det = service.getAdminNotificationById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdminNotificationDto> saveAdminNotification(@RequestBody AdminNotificationDto dto) {
        AdminNotificationDto created = service.saveAdminNotification(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteAdminNotification(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteAdminNotification(id);
        if (deleted) {
            return ResponseEntity.ok("Admin notification deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
