package com.biglikuryer.bigliplus.api.restaurant.controller;

import com.biglikuryer.bigliplus.dto.restaurant.RestaurantDto;
import com.biglikuryer.bigliplus.model.LoginRequest;
import com.biglikuryer.bigliplus.service.impl.restaurant.RestaurantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/login/restaurant")
public class RestaurantLoginController {

    private final RestaurantServiceImpl restaurantServiceImpl;

    public RestaurantLoginController(RestaurantServiceImpl restaurantServiceImpl) {
        this.restaurantServiceImpl = restaurantServiceImpl;
    }

    // Login
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String phoneNumber = loginRequest.getPhoneNumber();
        String password = loginRequest.getPassword();

        RestaurantDto restaurantDto = restaurantServiceImpl.findRestaurantByPhoneNumber(phoneNumber);

        if (restaurantDto != null && restaurantDto.getPassword().equals(password)) {
            if (!restaurantDto.getIsDisable()) {
                return ResponseEntity.ok(restaurantDto);
            } else {
                ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("This user is inactive or deleted");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                "Invalid username, email or password");
    }
}
