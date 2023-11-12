package com.biglikuryer.bigliplus.api.restaurant.controller;

import com.biglikuryer.bigliplus.dto.restaurant.RestaurantDto;
import com.biglikuryer.bigliplus.service.impl.restaurant.RestaurantServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/create/restaurant")
public class RestaurantRegisterController {

    private final RestaurantServiceImpl restaurantServiceImpl;

    public RestaurantRegisterController(RestaurantServiceImpl restaurantServiceImpl) {
        this.restaurantServiceImpl = restaurantServiceImpl;
    }

    // Create
    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantServiceImpl.createRestaurant(restaurantDto);
    }
}
