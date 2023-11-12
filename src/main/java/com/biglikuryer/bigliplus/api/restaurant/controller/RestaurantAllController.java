package com.biglikuryer.bigliplus.api.restaurant.controller;

import com.biglikuryer.bigliplus.dto.restaurant.RestaurantDto;
import com.biglikuryer.bigliplus.service.impl.restaurant.RestaurantServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v3/restaurants")
public class RestaurantAllController {
    private final RestaurantServiceImpl restaurantServiceImpl;

    public RestaurantAllController(RestaurantServiceImpl restaurantServiceImpl) {
        this.restaurantServiceImpl = restaurantServiceImpl;
    }

    // List
    @GetMapping
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantServiceImpl.getAllRestaurants();
    }
}
