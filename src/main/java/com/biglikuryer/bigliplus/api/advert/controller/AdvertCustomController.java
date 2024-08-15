package com.biglikuryer.bigliplus.api.advert.controller;

import com.biglikuryer.bigliplus.dto.advert.AdvertDto;
import com.biglikuryer.bigliplus.service.impl.advert.AdvertServiceImpl;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/advert")
public class AdvertCustomController {
    private final AdvertServiceImpl advertServiceImpl;

    public AdvertCustomController(AdvertServiceImpl advertServiceImpl) {
        this.advertServiceImpl = advertServiceImpl;
    }

    // List
    @GetMapping
    public ResponseEntity<List<AdvertDto>> getAllAdverts() {
        List<AdvertDto> advertDtoList = advertServiceImpl.getAllAdverts();
        return ResponseEntity.ok(advertDtoList);
    }

    // Create
    @PostMapping
    public ResponseEntity<AdvertDto> createAdvert(@RequestBody AdvertDto advertDto) {
        AdvertDto createdAdvert = advertServiceImpl.createAdvert(advertDto);
        return ResponseEntity.ok(createdAdvert);
    }

    // Id
    @GetMapping("/{advertId}")
    public ResponseEntity<AdvertDto> findAdvertById(@PathVariable Long advertId) {
        AdvertDto advertDto = advertServiceImpl.getAdvertById(advertId);
        if (advertDto != null) {
            return ResponseEntity.ok(advertDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/{advertId}")
    public ResponseEntity<?> updateAdvert(
            @PathVariable Long advertId,
            @RequestBody AdvertDto advertDto) {

        try {
            AdvertDto updatedAdvert = advertServiceImpl.updateAdvert(advertId, advertDto);
            if (updatedAdvert != null) {
                return ResponseEntity.ok(updatedAdvert);
            }
            return ResponseEntity.notFound().build();
        } catch (OptimisticLockException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Advert has been modified by another user. Please try again.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/{advertId}")
    public ResponseEntity<String> deleteAdvert(@PathVariable Long advertId) {
        boolean deleted = advertServiceImpl.removeById(advertId);
        if (deleted) {
            return ResponseEntity.ok("Advert deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
