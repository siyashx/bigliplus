package com.biglikuryer.bigliplus.api.restaurant.controller;

import com.biglikuryer.bigliplus.dto.restaurant.RestaurantDto;
import com.biglikuryer.bigliplus.service.impl.restaurant.RestaurantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/restaurant")
public class RestaurantCustomController {

    private final RestaurantServiceImpl restaurantServiceImpl;

    public RestaurantCustomController(RestaurantServiceImpl restaurantServiceImpl) {
        this.restaurantServiceImpl = restaurantServiceImpl;
    }

    // Id
    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable("restaurantId") Long restaurantId) {
        RestaurantDto restaurantDto = restaurantServiceImpl.getRestaurantById(restaurantId);
        if (restaurantDto != null) {
            return ResponseEntity.ok(restaurantDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Restaurant doesn't exist with given id..");
    }

    // Update
    @PutMapping("/{restaurantId}")
    public ResponseEntity<?> updateRestaurant(
            @PathVariable("restaurantId") Long id,
            @RequestBody RestaurantDto restaurantDto
    ) {
        RestaurantDto updatedRestaurant = restaurantServiceImpl.updateRestaurant(id, restaurantDto);
        if (updatedRestaurant != null) {
            return ResponseEntity.ok(updatedRestaurant);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable("restaurantId") Long restaurantId) {
        restaurantServiceImpl.deleteRestaurantById(restaurantId);
        return ResponseEntity.ok().build();
    }
}
