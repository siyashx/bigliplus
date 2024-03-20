package com.biglikuryer.bigliplus.api.admin.controller;

import com.biglikuryer.bigliplus.dto.admin.AdminDto;
import com.biglikuryer.bigliplus.service.impl.admin.AdminServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/admin")
public class AdminCustomController {

    private final AdminServiceImpl adminServiceImpl;

    public AdminCustomController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }


    // Id
    @GetMapping("/{adminId}")
    public ResponseEntity<?> getAdminById(@PathVariable("adminId") Long adminId) {
        AdminDto adminDto = adminServiceImpl.getAdminById(adminId);
        if (adminDto != null) {
            return ResponseEntity.ok(adminDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Admin doesn't exist with given id..");
    }

    // Update
    @PutMapping("/{adminId}")
    public ResponseEntity<?> updateAdmin(
            @PathVariable("adminId") Long id,
            @RequestBody AdminDto adminDto) {
        AdminDto updatedAdmin = adminServiceImpl.updateAdmin(id, adminDto);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        }
        return ResponseEntity.notFound().build();
    }
}
